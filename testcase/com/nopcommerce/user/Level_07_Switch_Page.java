package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject_NopCommerce_User.User_AddressesPageObject;
import PageObject_NopCommerce_User.User_CusstomerInforPageObject;
import PageObject_NopCommerce_User.User_HomePageObject;
import PageObject_NopCommerce_User.User_LoginPageObject;
import PageObject_NopCommerce_User.User_MyProductReviewsPageObject;
import PageObject_NopCommerce_User.User_RegisterPageObject;
import PageObject_NopCommerce_User.User_RewardPointsPageObject;
import commons.BaseTest;
import commons.PageGeneratorManager;

public class Level_07_Switch_Page extends BaseTest {

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
	private User_CusstomerInforPageObject cusstomerInforPage;
	private User_AddressesPageObject addressesPage;
	private User_MyProductReviewsPageObject myProductReviewPage;
	private User_RewardPointsPageObject rewardPointsPage;

}
