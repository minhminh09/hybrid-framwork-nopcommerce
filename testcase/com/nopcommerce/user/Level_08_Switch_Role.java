package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import PageObject_Nopcommerce_Admin.AdminDashboardPageObject;
import PageObject_Nopcommerce_Admin.AdminLoginPageObject;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;

public class Level_08_Switch_Role extends BaseTest {

	// private Admin_DashboardPO dashboardPage;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		// System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		// driver = new FirefoxDriver();
		// driver.get("https://demo.nopcommerce.com/");
		// // 1
		user_homePage = PageGeneratorManager.getUserHomePage(driver);
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		firtName = "Automation";
		lastName = "Testing";
		// emailAddress = "auto" + generateFakeNumber() + "@gmail.com";
		emailAddress = "autotest@gmail.com";
		password = "123456";
		user_homePage = new User_HomePageObject(driver);
		emailAddress_Admin = "admin@yourstore.com";
		password_Admin = "admin";
	}

	// @Test
	// public void TC_01_Register() {
	// user_registerPage = user_homePage.clickToRegisterLink();
	//
	// user_registerPage.inputToFirtNameTextbox(firtName);
	// user_registerPage.inputToLastNameTextbox(lastName);
	// user_registerPage.inputToEmailNameTextbox(emailAddress);
	// user_registerPage.inputToPassWordNameTextbox(password);
	// user_registerPage.inputToConfirmPassWordTextbox(password);
	//
	// user_registerPage.clickToRegisterButton();
	//
	// Assert.assertEquals(user_registerPage.getSussesfullMessage(), "Your registration completed");
	// user_homePage = user_registerPage.clickToLogoutLink();
	// }

	@Test
	public void Role_02_Login_User() {
		user_loginPage = user_homePage.clickToLoginLink();
		// loginPage = homePage.openLoginPage();

		// Login as User role
		user_homePage = user_loginPage.loginAsUser(emailAddress, password);
		Assert.assertTrue(user_homePage.isMyAccountLinkDisplay());

		// home Page=>My product review
		user_myProductReviewPage = user_homePage.openMyProducReviewPage(driver);

		// My product review =>Logout page =>Home Page
		user_homePage = user_myProductReviewPage.clickToLogoutLinkAtUserPage(driver);

		// User Home Page =>Open Admin Page =>Login Page (admin)
		user_homePage.openPageURL(driver, GlobalConstants.URL_PAGE_ADMIN);
		admin_loginPage = PageGeneratorManager.getAdminLoginPage(driver);

		// login as admin role
		admin_DashboardPage = admin_loginPage.loginAsAdmin(emailAddress_Admin, password_Admin);
		Assert.assertTrue(admin_DashboardPage.isDashboardHeaderDisplay());

		// dashbord=>logout= >login
		admin_loginPage = admin_DashboardPage.clickToLogoutLinkAtAdminPage(driver);

	}

	@Test
	public void Role_03_Login_Admin() {

		user_homePage.openPageURL(driver, GlobalConstants.URL_PAGE_ADMIN);
		admin_loginPage = PageGeneratorManager.getAdminLoginPage(driver);

		// login as admin role
		admin_DashboardPage = admin_loginPage.loginAsAdmin(emailAddress_Admin, password_Admin);
		Assert.assertTrue(admin_DashboardPage.isDashboardHeaderDisplay());
	}

	@Test
	public void TC_04_Switch_User_Role() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private String emailAddress, emailAddress_Admin, password_Admin;
	private String firtName, lastName, password;
	private User_HomePageObject user_homePage;
	private User_RegisterPageObject user_registerPage;
	private User_LoginPageObject user_loginPage;
	private User_CusstomerInforPageObject user_cusstomerInforPage;
	private User_AddressesPageObject user_addressesPage;
	private User_MyProductReviewsPageObject user_myProductReviewPage;
	private User_RewardPointsPageObject user_rewardPointsPage;
	private AdminLoginPageObject admin_loginPage;
	private AdminDashboardPageObject admin_DashboardPage;

	private String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;
}
