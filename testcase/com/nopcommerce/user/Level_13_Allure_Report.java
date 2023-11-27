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
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners(org.uncommons.reportng.HTMLReporter.class)
public class Level_13_Allure_Report extends BaseTest {

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

	@Description("Register to system")
	@Severity(SeverityLevel.NORMAL)
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

	}

	@Description("Login to system")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_01_User_Login() {
		loginPage = homePage.clickToLoginLink();

		loginPage.inputToEmailTextbox(emailAddress);

		loginPage.inputToPassWordNameTextbox(password);

		homePage = loginPage.clickToLogInButton();

		Assert.assertTrue(homePage.isMyAccountLinkDisplay());

		customerInforPage = loginPage.clickToMyAccoutLink();

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
