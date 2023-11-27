package com.nopcomerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import PageObject_NopCommerce_User.User_HomePageObject;
import PageObject_NopCommerce_User.User_LoginPageObject;
import PageObject_NopCommerce_User.User_RegisterPageObject;
import commons.BaseTest;
import commons.PageGeneratorManager;

@Listeners(commons.MethodListener.class)
public class common_01_Register_Cookie extends BaseTest {

	@Parameters("browser")
	@BeforeTest(description = "Creat new common User for All Class Tesst")

	public void TC_01_Register_Login(String browserName) {

		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firtName = "Automation";
		lastName = "Testing";
		emailAddress = "auto" + generateFakeNumber() + "@gmail.com";
		password = "123456";
		homePage = new User_HomePageObject(driver);

		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register - Step 02: Enter to firtname textbox with value is ' " + firtName + "' ");
		registerPage.inputToFirtNameTextbox(firtName);

		log.info("Register - Step 03: Enter to lastName textbox with value is ' " + lastName + "' ");
		registerPage.inputToLastNameTextbox(lastName);

		log.info("Register - Step 04: Enter to emailAddress textbox with value is ' " + emailAddress + "' ");
		registerPage.inputToEmailNameTextbox(emailAddress);

		log.info("Register - Step 05: Enter to password textbox with value is ' " + password + "' ");
		registerPage.inputToPassWordNameTextbox(password);

		log.info("Register - Step 06: Enter to confirm password textbox with value is ' " + password + "' ");
		registerPage.inputToConfirmPassWordTextbox(password);

		log.info("Register - Step 07: Click to register button");
		registerPage.clickToRegisterButton();

		log.info("Register - Step 08: Verify message Sussesfull isDisplay");
		Assert.assertEquals(registerPage.getSussesfullMessage(), "Your registration completed");

		log.info("HomePagr - Step 09: Click to Logout Link");
		homePage = registerPage.clickToLogoutLink();

		log.info("Login page - Step 01: Click to Login Link");
		loginPage = homePage.clickToLoginLink();

		log.info("Register - Step 02: Enter to firtname textbox with value is ' " + firtName + "' ");
		loginPage.inputToEmailTextbox(emailAddress);

		log.info("Register - Step 03: Enter to password textbox with value is ' " + password + "' ");
		loginPage.inputToPassWordNameTextbox(password);

		log.info("Login page - Step 04: Click to Login Button");
		homePage = loginPage.clickToLogInButton();

		loggedCookies = homePage.getAllCookies(driver);
		for (Cookie cookie : loggedCookies) {
			System.out.println("Cookie add common Class" + cookie);
		}
	}

	@AfterTest
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private String emailAddress, password;
	private String firtName, lastName;
	private User_HomePageObject homePage;
	private User_RegisterPageObject registerPage;
	private User_LoginPageObject loginPage;
	public static Set<Cookie> loggedCookies;

}
