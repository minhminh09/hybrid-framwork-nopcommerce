package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
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

@Listeners(org.uncommons.reportng.HTMLReporter.class)
public class Level_12_ReportNG_Screenshot extends BaseTest {

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

	}

	@Test
	public void TC_01_User_Login() {
		log.info("Login page - Step 01: Click to Login Link");
		loginPage = homePage.clickToLoginLink();

		log.info("Register - Step 02: Enter to firtname textbox with value is ' " + firtName + "' ");
		loginPage.inputToEmailTextbox(emailAddress);

		log.info("Register - Step 03: Enter to password textbox with value is ' " + password + "' ");
		loginPage.inputToPassWordNameTextbox(password);

		log.info("Login page - Step 04: Click to Login Button");
		homePage = loginPage.clickToLogInButton();

		log.info("Login page - Step 05: Verify My Accout Link Display");
		Assert.assertTrue(homePage.isMyAccountLinkDisplay());

		log.info("Login page - Step 06: Click to My Accout Link");
		customerInforPage = loginPage.clickToMyAccoutLink();

		log.info("Login page - Step 07: Verify My Account Page Display");
		Assert.assertFalse(customerInforPage.isMyaccountPageDisplay());
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
