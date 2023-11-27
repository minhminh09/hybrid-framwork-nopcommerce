package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObject_NopCommerce_User.User_HomePageObject;
import PageObject_NopCommerce_User.User_RegisterPageObject;

public class Level_03_Page_Object_01_Register {
	private WebDriver driver;
	private String emailAddress;
	private String firtName, lastName, password;
	private String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;
	private User_HomePageObject homePage;
	private User_RegisterPageObject registerPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		firtName = "Automation";
		lastName = "Testing";
		emailAddress = "auto" + generateFakeNumber() + "@gmail.com";
		password = "123456";

		homePage = new User_HomePageObject(driver);

	}

	@Test
	public void TC_01_Register_Empty_Data() {

		System.out.println("Home Page - Step 01 - Click to Register Link");
		homePage.clickToRegisterLink();
		registerPage = new User_RegisterPageObject(driver);

		System.out.println("Register Page - Step 02 - Click button Register");
		registerPage.clickToRegisterButton();

		// System.out.println("Register page - Step 03- Verify message error");
		Assert.assertEquals(registerPage.getErrorMessageAtFirtNameTextBox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextBox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextBox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPassWordTextBox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPassWordTextBox(), "Password is required.");

	}

	@Test
	public void TC_02_Register_Invalid_Email() {

		System.out.println("Home Page - Step 01 - Click to Register Link");
		homePage.clickToRegisterLink();
		registerPage = new User_RegisterPageObject(driver);

		System.out.println("Register Page - Step 02 - Input data fiel");
		registerPage.inputToFirtNameTextbox(firtName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailNameTextbox("Automation@@");
		registerPage.inputToPassWordNameTextbox(password);
		registerPage.inputToConfirmPassWordTextbox(password);

		System.out.println("Register Page - Step 03 - Click button Register");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page - Step 04 - Verify message error");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextBox(), "Wrong email");

	}

	@Test
	public void TC_03_Register_Susscess() {

		System.out.println("Home Page - Step 01 - Click to Register Link");
		homePage.clickToRegisterLink();
		registerPage = new User_RegisterPageObject(driver);

		System.out.println("Register Page - Step 02 - Input data fiel");
		registerPage.inputToFirtNameTextbox(firtName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailNameTextbox(emailAddress);
		registerPage.inputToPassWordNameTextbox(password);
		registerPage.inputToConfirmPassWordTextbox(password);

		System.out.println("Register Page - Step 03 - Click button Register");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page - Step 04 - Verify message susscesfull");
		Assert.assertEquals(registerPage.getSussesfullMessage(), "Your registration completed");

		System.out.println("Home Page - Step 05 - Click to Logout Link");
		registerPage.clickToLogoutLink();

	}

	@Test
	public void TC_04_Register_Email_Already_Exits() {

		System.out.println("Home Page - Step 01 - Click to Register Link");
		homePage.clickToRegisterLink();
		registerPage = new User_RegisterPageObject(driver);

		System.out.println("Register Page - Step 02 - Input data fiel");
		registerPage.inputToFirtNameTextbox(firtName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailNameTextbox(emailAddress);
		registerPage.inputToPassWordNameTextbox(password);
		registerPage.inputToConfirmPassWordTextbox(password);

		System.out.println("Register Page - Step 03 - Click button Register");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page - Step 04 - Verify message error");
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
	}

	@Test
	public void TC_05_Register_Password_less_than_6_char() {

		System.out.println("Home Page - Step 01 - Click to Register Link");
		homePage.clickToRegisterLink();
		registerPage = new User_RegisterPageObject(driver);

		System.out.println("Register Page - Step 02 - Input data fiel");
		registerPage.inputToFirtNameTextbox(firtName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailNameTextbox(emailAddress);
		registerPage.inputToPassWordNameTextbox("1234");
		registerPage.inputToConfirmPassWordTextbox(password);

		System.out.println("Register Page - Step 03 - Click button Register");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page - Step 04 - Verify message error");
		Assert.assertEquals(registerPage.getErrorMessageAtPassWordTextBox(), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void TC_06_Register_Invalid_confirmPassword() {

		System.out.println("Home Page - Step 01 - Click to Register Link");
		homePage.clickToRegisterLink();
		registerPage = new User_RegisterPageObject(driver);

		System.out.println("Register Page - Step 02 - Input data fiel");
		registerPage.inputToFirtNameTextbox(firtName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailNameTextbox(emailAddress);
		registerPage.inputToPassWordNameTextbox(password);
		registerPage.inputToConfirmPassWordTextbox("1234567");

		System.out.println("Register Page - Step 03 - Click button Register");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page - Step 04 - Verify message error");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPassWordTextBox(), "The password and confirmation password do not match.");

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
