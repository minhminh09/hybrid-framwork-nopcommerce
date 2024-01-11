package PageObject_Wordpress_Admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUI_wordpress_admin.Admin_login_UI;

public class Admin_LoginPO extends BasePage {
	WebDriver driver;

	public Admin_LoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToUsernameTextbox(String adminUsername) {
		waitForElementVisible(driver, Admin_login_UI.USERNAME_TEXTBOX);
		senkeyToElement(driver, Admin_login_UI.USERNAME_TEXTBOX, adminUsername);

	}

	public void enterToPassWordTextbox(String adminPassword) {
		waitForElementVisible(driver, Admin_login_UI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, Admin_login_UI.PASSWORD_TEXTBOX, adminPassword);

	}

	public Admin_DashboardPO clicktoButtonLogin() {
		waitForElementVisible(driver, Admin_login_UI.LOGIN_BUTTON);
		clickToElement(driver, Admin_login_UI.LOGIN_BUTTON);
		return PageObject_Wordpress_Admin.PageGeneratorManager.w_getAdminDashboardPage(driver);

	}

}
