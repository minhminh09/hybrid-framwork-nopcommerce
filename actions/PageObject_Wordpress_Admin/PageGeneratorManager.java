package PageObject_Wordpress_Admin;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static Admin_LoginPO w_getAdminLoginPage(WebDriver driver) {
		return new Admin_LoginPO(driver);
	}

	public static Admin_DashboardPO getAdminDashboardPage(WebDriver driver) {
		return new Admin_DashboardPO(driver);
	}
	//
	// public static Admin_PostSearchPO getAdminPostSearchPage(WebDriver driver) {
	// return new Admin_PostSearchPO(driver);
	// }
	//
	// public static Admin_PostAddNewPO getAdminPostAddNewPage(WebDriver driver) {
	// return new Admin_PostAddNewPO(driver);
	// }

	// public static Admin_LoginPO w_getAdminLoginPage(WebDriver driver) {
	// // TODO Auto-generated method stub
	// return new Admin_LoginPO(driver);
	// }

	public static Admin_PostSearchPO w_getAdminPostSearchPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new Admin_PostSearchPO(driver);
	}

	public static Admin_PostAddNewPO w_getAdminPostAddNewPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new Admin_PostAddNewPO(driver);
	}

	public static Admin_DashboardPO w_getAdminDashboardPage(WebDriver driver) {
		return new Admin_DashboardPO(driver);
	}

}
