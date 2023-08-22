package com.liveguru.user;

import org.testng.annotations.Test;

import PageObjectLiveGuru.DashboardPageObject;
import PageObjectLiveGuru.HomePageObject;
import PageObjectLiveGuru.LoginPageObject;
import PageObjectLiveGuru.PageGeneratorManager;
import PageObjectLiveGuru.RegisterPageObject;
import commons.BasePage;
import commons.BaseTest;

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

public class Level_02_Page_Generator_Manager_1 extends BaseTest {
	private WebDriver driver;
	private String emailAddress;
	private String firtName, lastName, password, invalidEmail, notFoundEmail;
	WebDriverWait explicitWait;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private DashboardPageObject dashBoardPage;

	@BeforeClass
	public void beforeClass() {

		homePage = PageGeneratorManager.getHomePage(driver);

		firtName = "Automation";
		lastName = "Testing";
		emailAddress = "auto" + generateFakeNumber() + "@gmail.com";
		password = "123456";
		invalidEmail = "auto@@";
		notFoundEmail = "auto" + generateFakeNumber() + "@gmail.vn";
		homePage = new HomePageObject(driver);

	}

	@Test
	public void TC_01_Login_Empty_Data() {

		homePage.clickToMyAccountLink();

		loginPage.clickToCreatAnAccountButton();
		loginPage = new LoginPageObject(driver);

		registerPage = new RegisterPageObject(driver);

		registerPage.inputToFirtNameTextbox(firtName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailNameTextbox(emailAddress);
		registerPage.inputToPassWordNameTextbox(password);
		registerPage.inputToConfirmPassWordTextbox(password);

		registerPage.clickToRegisterButton();
		dashBoardPage = new DashboardPageObject(driver);

		Assert.assertEquals(dashBoardPage.getMessageCussesfull(), "Thank you for registering with Main Website Store.");
		homePage.clickToAccountLink();
		homePage.clickToLogOutLink();
	}

	@Test
	public void TC_02_Login_Invalid_Email() {

		homePage.clickToAccountLink();

		homePage.clickToLogInLink();
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailNameTextbox(emailAddress);
		loginPage.inputToPassWordNameTextbox(password);

		loginPage.clickToLoginButton();

		dashBoardPage = new DashboardPageObject(driver);
		Assert.assertEquals(dashBoardPage.getMessageCussesfull(), "MY DASHBOARD");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
