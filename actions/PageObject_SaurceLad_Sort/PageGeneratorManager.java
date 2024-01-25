package PageObject_SaurceLad_Sort;

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
	public static LoginPage getLoginPage(WebDriver driver) {
		return new LoginPage(driver);
	}

	public static ProductPage getProductPage(WebDriver driver) {
		return new ProductPage(driver);
	}

}
