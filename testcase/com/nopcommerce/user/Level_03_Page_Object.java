package com.nopcommerce.user;

import org.testng.annotations.Test;

import PageObject.HomePageObject;
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

public class Level_03_Page_Object {
	WebDriver driver;
	String emailAddress;

	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;
	HomePageObject homePage;
	RegisterPageObject registerPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.get("https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		emailAddress = "auto" + generateFakeNumber() + "@gmail.com";
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		// waitForElementClick(driver, "//a[@class='ico-register']");
		// clickToElement(driver, "//a[@class='ico-register']");
		System.out.println("Home Page - Step 01 - Click to Register Link");
		homePage.clickToRegisterLink();

		// waitForElementClick(driver, "//button[@id='register-button']");
		// clickToElement(driver, "//button[@id='register-button']");
		System.out.println("Register Page - Step 02 - Click button Register");
		registerPage.clickToRegisterButton();

		// Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
		// Assert.assertEquals(getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		// Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		// Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		// Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
		System.out.println("Register page - Step 03- Verify message error");
		Assert.assertEquals(registerPage.getErrorMessageAtFirtNameTextBox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextBox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextBox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPassWordTextBox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPassWordTextBox(), "Password is required.");

	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		// waitForElementClick(driver, "//a[@class='ico-register']");
		// clickToElement(driver, "//a[@class='ico-register']");
		System.out.println("Home Page - Step 01 - Click to Register Link");
		homePage.clickToRegisterLink();

		// senkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		// senkeyToElement(driver, "//input[@id='LastName']", "Testing");
		// senkeyToElement(driver, "//input[@id='Email']", "Automation@@");
		// senkeyToElement(driver, "//input[@id='Password']", "123456");
		// senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
		System.out.println("Register Page - Step 02 - Input data fiel");
		registerPage.inputToFirtNameTextbox("Automation");
		registerPage.inputToLastNameTextbox("Testing");
		registerPage.inputToEmailNameTextbox("Automation@@");
		registerPage.inputToPassWordNameTextbox("123456");
		registerPage.inputToConfirmPassWordTextbox("123456");

		// waitForElementClick(driver, "//button[@id='register-button']");
		// clickToElement(driver, "//button[@id='register-button']");
		System.out.println("Register Page - Step 03 - Click button Register");
		registerPage.clickToRegisterButton();

		// Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
		System.out.println("Register Page - Step 04 - Verify message error");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextBox(), "Wrong email");

	}

	@Test
	public void TC_03_Register_Susscess() {
		// waitForElementClick(driver, "//a[@class='ico-register']");
		// clickToElement(driver, "//a[@class='ico-register']");
		System.out.println("Home Page - Step 01 - Click to Register Link");
		homePage.clickToRegisterLink();

		// senkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		// senkeyToElement(driver, "//input[@id='LastName']", "Testing");
		// senkeyToElement(driver, "//input[@id='Email']", emailAddress);
		// senkeyToElement(driver, "//input[@id='Password']", "123456");
		// senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
		System.out.println("Register Page - Step 02 - Input data fiel");
		registerPage.inputToFirtNameTextbox("Automation");
		registerPage.inputToLastNameTextbox("Testing");
		registerPage.inputToEmailNameTextbox(emailAddress);
		registerPage.inputToPassWordNameTextbox("123456");
		registerPage.inputToConfirmPassWordTextbox("123456");

		// waitForElementClick(driver, "//button[@id='register-button']");
		// clickToElement(driver, "//button[@id='register-button']");
		System.out.println("Register Page - Step 03 - Click button Register");
		registerPage.clickToRegisterButton();

		// Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");
		System.out.println("Register Page - Step 04 - Verify message susscesfull");
		Assert.assertEquals(registerPage.getSussesfullMessage(), "Your registration completed");

		// waitForElementClick(driver, "//a[@class='ico-login']");
		// clickToElement(driver, "//a[@class='ico-login']");
		System.out.println("Home Page - Step 05 - Click to Logout Link");
		registerPage.clickToLogoutLink();

	}

	@Test
	public void TC_04_Register_Email_Already_Exits() {
		// waitForElementClick(driver, "//a[@class='ico-register']");
		// clickToElement(driver, "//a[@class='ico-register']");
		System.out.println("Home Page - Step 01 - Click to Register Link");
		homePage.clickToRegisterLink();

		// senkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		// senkeyToElement(driver, "//input[@id='LastName']", "Testing");
		// senkeyToElement(driver, "//input[@id='Email']", emailAddress);
		// senkeyToElement(driver, "//input[@id='Password']", "123456");
		// senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		System.out.println("Register Page - Step 02 - Input data fiel");
		registerPage.inputToFirtNameTextbox("Automation");
		registerPage.inputToLastNameTextbox("Testing");
		registerPage.inputToEmailNameTextbox(emailAddress);
		registerPage.inputToPassWordNameTextbox("123456");
		registerPage.inputToConfirmPassWordTextbox("123456");

		// waitForElementClick(driver, "//button[@id='register-button']");
		// clickToElement(driver, "//button[@id='register-button']");

		System.out.println("Register Page - Step 03 - Click button Register");
		registerPage.clickToRegisterButton();

		// Assert.assertEquals(getElementText(driver, "//div[contains(@class,'message-error')]//li"), "The specified email already exists");

		System.out.println("Register Page - Step 04 - Verify message error");
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
	}

	@Test
	public void TC_05_Register_Password_less_than_6_char() {
		// waitForElementClick(driver, "//a[@class='ico-register']");
		// clickToElement(driver, "//a[@class='ico-register']");

		System.out.println("Home Page - Step 01 - Click to Register Link");
		homePage.clickToRegisterLink();

		// senkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		// senkeyToElement(driver, "//input[@id='LastName']", "Testing");
		// senkeyToElement(driver, "//input[@id='Email']", emailAddress);
		// senkeyToElement(driver, "//input[@id='Password']", "123");
		// senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		System.out.println("Register Page - Step 02 - Input data fiel");
		registerPage.inputToFirtNameTextbox("Automation");
		registerPage.inputToLastNameTextbox("Testing");
		registerPage.inputToEmailNameTextbox(emailAddress);
		registerPage.inputToPassWordNameTextbox("1234");
		registerPage.inputToConfirmPassWordTextbox("123456");

		// waitForElementClick(driver, "//button[@id='register-button']");
		// clickToElement(driver, "//button[@id='register-button']");

		System.out.println("Register Page - Step 03 - Click button Register");
		registerPage.clickToRegisterButton();

		// Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6
		// characters");

		System.out.println("Register Page - Step 04 - Verify message error");
		Assert.assertEquals(registerPage.getErrorMessageAtPassWord(), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void TC_06_Register_Invalid_confirmPassword() {

		// waitForElementClick(driver, "//a[@class='ico-register']");
		// clickToElement(driver, "//a[@class='ico-register']");
		//
		System.out.println("Home Page - Step 01 - Click to Register Link");
		homePage.clickToRegisterLink();

		// senkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		// senkeyToElement(driver, "//input[@id='LastName']", "Testing");
		// senkeyToElement(driver, "//input[@id='Email']", emailAddress);
		// senkeyToElement(driver, "//input[@id='Password']", "123456");
		// senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123457");

		System.out.println("Register Page - Step 02 - Input data fiel");
		registerPage.inputToFirtNameTextbox("Automation");
		registerPage.inputToLastNameTextbox("Testing");
		registerPage.inputToEmailNameTextbox(emailAddress);
		registerPage.inputToPassWordNameTextbox("123456");
		registerPage.inputToConfirmPassWordTextbox("1234567");
		//
		// waitForElementClick(driver, "//button[@id='register-button']");
		// clickToElement(driver, "//button[@id='register-button']");

		System.out.println("Register Page - Step 03 - Click button Register");
		registerPage.clickToRegisterButton();

		// Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");

		System.out.println("Register Page - Step 04 - Verify message error");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPassWord(), "The password and confirmation password do not match.");

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
