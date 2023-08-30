package com.nopcommerce.user;

import org.testng.annotations.Test;

import PageObjectLiveGuru.DashboardPageObject;
import PageObject_NopCommerce_User.User_AddressesPageObject;
import PageObject_NopCommerce_User.User_CusstomerInforPageObject;
import PageObject_NopCommerce_User.User_HomePageObject;
import PageObject_NopCommerce_User.User_LoginPageObject;
import PageObject_NopCommerce_User.User_MyProductReviewsPageObject;
import PageObject_NopCommerce_User.User_RegisterPageObject;
import PageObject_NopCommerce_User.User_RewardPointsPageObject;
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

public class Level_09_DynamicLocator extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firtName = "Automation";
		lastName = "Testing";
		emailAddress = "auto" + generateFakeNumber() + "@gmail.com";
		password = "123456";
		homePage = new User_HomePageObject(driver);
	}

	@Test
	public void TC_01_Register_Login() {
		registerPage = homePage.clickToRegisterLink();

		registerPage.inputToFirtNameTextbox(firtName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailNameTextbox(emailAddress);
		registerPage.inputToPassWordNameTextbox(password);
		registerPage.inputToConfirmPassWordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getSussesfullMessage(), "Your registration completed");
		homePage = registerPage.clickToLogoutLink();

		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPassWordNameTextbox(password);

		homePage = loginPage.clickToLogInButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplay());

		customerInforPage = loginPage.clickToMyAccoutLink();

		Assert.assertTrue(customerInforPage.isMyaccountPageDisplay());
	}

	@Test
	public void TC_02_Switch_Page() {
		// CusstomerInfor =>Addresses
		addressesPage = customerInforPage.openAddressesPage(driver);
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
	public void TC_03_Dynamic_Page_01() {
		// Addresses=>CusstomerInfor
		customerInforPage = (User_CusstomerInforPageObject) addressesPage.openPageAtMyAcountByName(driver, "Customer info");

		// CusstomerInfor =>My Product review
		myProductReviewPage = (User_MyProductReviewsPageObject) customerInforPage.openPageAtMyAcountByName(driver, "My product reviews");

		// My product review =>Reward points
		rewardPointsPage = (User_RewardPointsPageObject) myProductReviewPage.openPageAtMyAcountByName(driver, "Reward points");

		// Reward points =>My Product review
		myProductReviewPage = (User_MyProductReviewsPageObject) rewardPointsPage.openPageAtMyAcountByName(driver, "My product reviews");

		// My Product review =>Addresses
		addressesPage = (User_AddressesPageObject) myProductReviewPage.openPageAtMyAcountByName(driver, "Addresses");
	}

	@Test
	public void TC_03_Dynamic_Page_02() {
		// Addresses=>Reward points
		addressesPage.openPageAtMyAcountBypageName(driver, "Reward points");
		rewardPointsPage = PageGeneratorManager.getUserRewardPointsPage(driver);
		// Addresses=>CusstomerInfor
		addressesPage.openPageAtMyAcountByName(driver, "Customer info");
		customerInforPage = PageGeneratorManager.getUserCusstomerInforPage(driver);
		// CusstomerInfor =>My Product review
		customerInforPage.openPageAtMyAcountByName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);
		// My product review =>Reward points
		myProductReviewPage.openPageAtMyAcountByName(driver, "Reward points");
		rewardPointsPage = PageGeneratorManager.getUserRewardPointsPage(driver);
		// Reward points =>My Product review
		rewardPointsPage.openPageAtMyAcountByName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);
		// My Product review =>Addresses
		myProductReviewPage.openPageAtMyAcountByName(driver, "Addresses");
		addressesPage = PageGeneratorManager.getUserAddressesPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private String emailAddress;
	private String firtName, lastName, password;
	private User_HomePageObject homePage;
	private User_RegisterPageObject registerPage;
	private User_LoginPageObject loginPage;
	private User_CusstomerInforPageObject customerInforPage;
	private User_AddressesPageObject addressesPage;
	private User_MyProductReviewsPageObject myProductReviewPage;
	private User_RewardPointsPageObject rewardPointsPage;

}
