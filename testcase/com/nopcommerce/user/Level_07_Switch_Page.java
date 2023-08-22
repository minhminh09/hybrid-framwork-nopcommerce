package com.nopcommerce.user;

import org.testng.annotations.Test;

import PageObjectLiveGuru.DashboardPageObject;
import PageObject_NopCommerce_Portal.AddressesPageObject;
import PageObject_NopCommerce_Portal.CusstomerInforPageObject;
import PageObject_NopCommerce_Portal.HomePageObject;
import PageObject_NopCommerce_Portal.LoginPageObject;
import PageObject_NopCommerce_Portal.MyProductReviewsPageObject;
import PageObject_NopCommerce_Portal.PageGeneratorManager;
import PageObject_NopCommerce_Portal.RegisterPageObject;
import PageObject_NopCommerce_Portal.RewardPointsPageObject;
import commons.BasePage;
import commons.BaseTest;

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

public class Level_07_Switch_Page extends BaseTest {

	// private DashboardPageObject dashboardPage;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
		// // 1
		homePage = PageGeneratorManager.getHomePage(driver);
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		firtName = "Automation";
		lastName = "Testing";
		emailAddress = "auto" + generateFakeNumber() + "@gmail.com";
		password = "123456";
		homePage = new HomePageObject(driver);
	}

	@Test
	public void TC_01_Register() {
		registerPage = homePage.clickToRegisterLink();

		registerPage.inputToFirtNameTextbox(firtName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailNameTextbox(emailAddress);
		registerPage.inputToPassWordNameTextbox(password);
		registerPage.inputToConfirmPassWordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getSussesfullMessage(), "Your registration completed");
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void TC_02_Login() {
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPassWordNameTextbox(password);

		homePage = loginPage.clickToLogInButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplay());

	}

	@Test
	public void TC_03_Customer_Infor() {
		cusstomerInforPage = loginPage.clickToMyAccoutLink();

		Assert.assertTrue(cusstomerInforPage.isMyaccountPageDisplay());
	}

	@Test
	public void TC_04_Switch_Page() {
		// CusstomerInfor =>Addresses
		addressesPage = cusstomerInforPage.openAddressesPage(driver);
		// Addresses =>My Product review
		myProductReviewPage = addressesPage.openMyProducReviewPage(driver);
		// My product review =>Reward points
		rewardPointsPage = myProductReviewPage.openRewardPointPage(driver);
		// Reward points =>My Product review
		myProductReviewPage = rewardPointsPage.openMyProducReviewPage(driver);
		// My Product review =>Addresses
		addressesPage = myProductReviewPage.openAddressesPage(driver);
	}

	@Test
	public void TC_04_Switch_User_Role() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private String emailAddress;
	private String firtName, lastName, password;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CusstomerInforPageObject cusstomerInforPage;
	private AddressesPageObject addressesPage;
	private MyProductReviewsPageObject myProductReviewPage;
	private RewardPointsPageObject rewardPointsPage;
	private String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;
}
