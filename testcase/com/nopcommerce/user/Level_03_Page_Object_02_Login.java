package com.nopcommerce.user;

import org.testng.annotations.Test;

import PageObject.HomePageObject;
import PageObject.LoginPageObject;
import PageObject.RegisterPageObject;
import commons.BasePage;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_03_Page_Object_02_Login {
	private WebDriver driver;
	private String emailAddress;
	private String firtName, lastName, password, invalidEmail, notFoundEmail;
	private String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		firtName = "Automation";
		lastName = "Testing";
		emailAddress = "auto" + generateFakeNumber() + "@gmail.com";
		password = "123456";
		invalidEmail = "auto@@";
		notFoundEmail = "auto" + generateFakeNumber() + "@gmail.vn";

		System.out.println("Pre-condition - Step 01 - Click to Register Link");
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);

		System.out.println("Pre-condition- Step 02 - Input data fiel");
		registerPage.inputToFirtNameTextbox(firtName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailNameTextbox(emailAddress);
		registerPage.inputToPassWordNameTextbox(password);
		registerPage.inputToConfirmPassWordTextbox(password);

		System.out.println("Pre-condition - Step 03 - Click button Register");
		registerPage.clickToRegisterButton();

		System.out.println("Pre-condition - Step 04 - Verify message susscesfull");
		Assert.assertEquals(registerPage.getSussesfullMessage(), "Your registration completed");

		System.out.println("Pre-condition - Step 05 - Click to Logout Link");
		registerPage.clickToLogoutLink();

	}

	@Test
	public void TC_01_Login_Empty_Data() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.clickToLogInButton();
		Assert.assertEquals(loginPage.getErrorMessageEmailTextBox(), "Please enter your email");
	}

	@Test
	public void TC_02_Login_Invalid_Email() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextbox(invalidEmail);
		// loginPage.inputToPassWordNameTextbox(password);
		loginPage.clickToLogInButton();
		Assert.assertEquals(loginPage.getErrorMessageEmailTextBox(), "Wrong email");

	}

	@Test
	public void TC_03_Login_Email_Not_Found() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(notFoundEmail);

		loginPage.clickToLogInButton();
		Assert.assertEquals(loginPage.getErrorMessageUncussesfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void TC_04_Login_Exiting_Email_Empty_Password() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPassWordNameTextbox("");

		loginPage.clickToLogInButton();
		Assert.assertEquals(loginPage.getErrorMessageUncussesfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void TC_05_Login_Exting_Email_Invalid_Password() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPassWordNameTextbox("456892");

		loginPage.clickToLogInButton();
		Assert.assertEquals(loginPage.getErrorMessageUncussesfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void TC_06_Login_Cussesfull() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPassWordNameTextbox(password);

		loginPage.clickToLogInButton();
		Assert.assertEquals(homePage.getMessageCussfull(), "Welcome to our store");
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
