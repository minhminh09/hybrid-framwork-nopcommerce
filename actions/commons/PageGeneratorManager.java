package commons;

import org.openqa.selenium.WebDriver;

import PageObject_NopCommerce_User.User_AddressesPageObject;
import PageObject_NopCommerce_User.User_CusstomerInforPageObject;
import PageObject_NopCommerce_User.User_HomePageObject;
import PageObject_NopCommerce_User.User_LoginPageObject;
import PageObject_NopCommerce_User.User_MyProductReviewsPageObject;
import PageObject_NopCommerce_User.User_RegisterPageObject;
import PageObject_NopCommerce_User.User_RewardPointsPageObject;
import PageObject_Nopcommerce_Admin.AdminDashboardPageObject;
import PageObject_Nopcommerce_Admin.AdminLoginPageObject;
import PageObject_Wordpress.Admin_DashboardPO;
import PageObject_Wordpress.Admin_LoginPO;
import PageObject_Wordpress.Admin_PostAddNewPO;
import PageObject_Wordpress.Admin_PostSearchPO;

public class PageGeneratorManager {
	public static User_HomePageObject getUserHomePage(WebDriver driver) {
		return new User_HomePageObject(driver);
	}

	public static User_LoginPageObject getUserLoginPage(WebDriver driver) {
		return new User_LoginPageObject(driver);
	}

	public static User_RegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new User_RegisterPageObject(driver);
	}

	public static User_CusstomerInforPageObject getUserCusstomerInforPage(WebDriver driver) {
		return new User_CusstomerInforPageObject(driver);
	}

	public static User_AddressesPageObject getUserAddressesPage(WebDriver driver) {
		return new User_AddressesPageObject(driver);
	}

	public static User_RewardPointsPageObject getUserRewardPointsPage(WebDriver driver) {
		return new User_RewardPointsPageObject(driver);
	}

	public static User_MyProductReviewsPageObject getUserMyProductReviewPage(WebDriver driver) {
		return new User_MyProductReviewsPageObject(driver);
	}

	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}

	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new AdminLoginPageObject(driver);
	}

}
