package com.nopcommerce.user;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcomerce.common.common_01_Register_Cookie;
import com.nopcomerce.common.common_01_Register_End_User;

import PageObject_NopCommerce_User.User_AddressesPageObject;
import PageObject_NopCommerce_User.User_CusstomerInforPageObject;
import PageObject_NopCommerce_User.User_HomePageObject;
import PageObject_NopCommerce_User.User_LoginPageObject;
import PageObject_NopCommerce_User.User_MyProductReviewsPageObject;
import PageObject_NopCommerce_User.User_RegisterPageObject;
import PageObject_NopCommerce_User.User_RewardPointsPageObject;
import commons.BaseTest;
import commons.PageGeneratorManager;

@Listeners(commons.MethodListener.class)
public class Level_14_Share_Data_B extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		emailAddress = common_01_Register_End_User.emailAddress;
		password = common_01_Register_End_User.password;

		log.info("Pre-Condition -Step 01: Navigate to login page");
		loginPage = homePage.clickToLoginLink();

		log.info("Pre-Condition - Step 02: set cookie and reload page");
		loginPage.setcookie(driver, common_01_Register_Cookie.loggedCookies);
		for (Cookie cookie : common_01_Register_Cookie.loggedCookies) {
			System.out.println("Cookie add common B Class" + cookie);
		}
		loginPage.refreshCurrentPage(driver);

		log.info("Pre-Condition - Step 05: Verify My Accout Link Display");
		Assert.assertTrue(homePage.isMyAccountLinkDisplay());

	}

	@Test
	public void Search_01_Empty_Data() {

	}

	@Test
	public void Search_02_Relative_Product_Name() {

	}

	@Test
	public void Search_03_Absolute_Product_Name() {

	}

	@Test
	public void Search_04_Parent_Category() {

	}

	@Test
	public void Search_05_Incorect_Manufacturer() {

	}

	@Test
	public void Search_06_Correct_Manufacturer() {

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
