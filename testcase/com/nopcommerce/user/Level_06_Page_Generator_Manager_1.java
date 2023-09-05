package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import PageObjectLiveGuru.DashboardPageObject;
import PageObject_NopCommerce_User.User_HomePageObject;
import PageObject_NopCommerce_User.User_LoginPageObject;
import PageObject_NopCommerce_User.User_RegisterPageObject;
import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_06_Page_Generator_Manager_1 extends BaseTest {
	private WebDriver driver;
	private String emailAddress;
	private String firtName, lastName, password, invalidEmail, notFoundEmail;
	private String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;
	private User_HomePageObject homePage;
	private User_RegisterPageObject registerPage;
	private User_LoginPageObject loginPage;
	private DashboardPageObject dashboardPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
		// 1
		homePage = PageGeneratorManager.getUserHomePage(driver);
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		firtName = "Automation";
		lastName = "Testing";
		emailAddress = "auto" + generateFakeNumber() + "@gmail.com";
		password = "123456";
		invalidEmail = "auto@@";
		notFoundEmail = "auto" + generateFakeNumber() + "@gmail.vn";

		System.out.println("Pre-condition - Step 01 - Click to Register Link");
		registerPage = homePage.clickToRegisterLink();

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
		homePage = registerPage.clickToLogoutLink();
		// 10s
		// homePage = new HomePageJqueryObject(driver);
	}

	@Test
	public void TC_01_Login_Empty_Data() {
		loginPage = homePage.clickToLoginLink();
		// 3

		loginPage.clickToLogInButton();
		Assert.assertEquals(loginPage.getErrorMessageEmailTextBox(), "Please enter your email");
	}

	@Test
	public void TC_02_Login_Invalid_Email() {
		loginPage = homePage.clickToLoginLink();
		// 4
		// loginPage = new LoginPageObject(driver);
		loginPage.inputToEmailTextbox(invalidEmail);
		// loginPage.inputToPassWordNameTextbox(password);
		loginPage.clickToLogInButton();
		Assert.assertEquals(loginPage.getErrorMessageEmailTextBox(), "Wrong email");

	}

	@Test
	public void TC_03_Login_Email_Not_Found() {
		loginPage = homePage.clickToLoginLink();
		// 5
		// loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(notFoundEmail);

		loginPage.clickToLogInButton();
		Assert.assertEquals(loginPage.getErrorMessageUncussesfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void TC_04_Login_Exiting_Email_Empty_Password() {
		loginPage = homePage.clickToLoginLink();
		// 6
		// loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPassWordNameTextbox("");

		loginPage.clickToLogInButton();
		Assert.assertEquals(loginPage.getErrorMessageUncussesfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void TC_05_Login_Exting_Email_Invalid_Password() {
		loginPage = homePage.clickToLoginLink();
		// 7
		// loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPassWordNameTextbox("456892");

		loginPage.clickToLogInButton();
		Assert.assertEquals(loginPage.getErrorMessageUncussesfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void TC_06_Login_Cussesfull() {
		loginPage = homePage.clickToLoginLink();
		// 8
		// loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPassWordNameTextbox(password);

		homePage = loginPage.clickToLogInButton();
		// 9
		// homePage = new HomePageJqueryObject(driver);
		Assert.assertEquals(homePage.getMessageCussfull(), "Welcome to our store");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
