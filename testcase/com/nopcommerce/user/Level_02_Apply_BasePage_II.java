package com.nopcommerce.user;

import org.testng.annotations.Test;

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

public class Level_02_Apply_BasePage_II {
	WebDriver driver;
	String emailAddress;

	// Declare (Khai bao)
	BasePage basePage;

	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		// Initial (Khoi tao)
		basePage = BasePage.getBasePaseObject();

		driver.get("https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		emailAddress = "auto" + generateFakeNumber() + "@gmail.com";
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		basePage.waitForElementClick(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.waitForElementClick(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		basePage.waitForElementClick(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.senkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		basePage.senkeyToElement(driver, "//input[@id='LastName']", "Testing");
		basePage.senkeyToElement(driver, "//input[@id='Email']", "Automation@@");
		basePage.senkeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		basePage.waitForElementClick(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Wrong email");

	}

	@Test
	public void TC_03_Register_Susscess() {
		basePage.waitForElementClick(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.senkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		basePage.senkeyToElement(driver, "//input[@id='LastName']", "Testing");
		basePage.senkeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.senkeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		basePage.waitForElementClick(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");

		basePage.waitForElementClick(driver, "//a[@class='ico-login']");
		basePage.clickToElement(driver, "//a[@class='ico-login']");
	}

	@Test
	public void TC_04_Register_Email_Already_Exits() {
		basePage.waitForElementClick(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.senkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		basePage.senkeyToElement(driver, "//input[@id='LastName']", "Testing");
		basePage.senkeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.senkeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		basePage.waitForElementClick(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//div[contains(@class,'message-error')]//li"), "The specified email already exists");
	}

	@Test
	public void TC_05_Register_Password_less_than_6_char() {
		basePage.waitForElementClick(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.senkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		basePage.senkeyToElement(driver, "//input[@id='LastName']", "Testing");
		basePage.senkeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.senkeyToElement(driver, "//input[@id='Password']", "123");
		basePage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		basePage.waitForElementClick(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void TC_06_Register_Invalid_confirmPassword() {

		basePage.waitForElementClick(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.senkeyToElement(driver, "//input[@id='FirstName']", "Automation");
		basePage.senkeyToElement(driver, "//input[@id='LastName']", "Testing");
		basePage.senkeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.senkeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123457");

		basePage.waitForElementClick(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
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
