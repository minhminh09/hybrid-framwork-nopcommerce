package PageObject_Nopcommerce_Admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs_Nopcommerce_Admin.Admin_LoginPageUI;

public class AdminLoginPageObject extends BasePage {
	private WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {

		this.driver = driver;
	}

	public void inputToEmailTextbox(String emailAddress_Admin) {
		waitForElementVisible(driver, Admin_LoginPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, Admin_LoginPageUI.EMAIL_TEXTBOX, emailAddress_Admin);
	}

	public void inputToPasswordTextbox(String password_Admin) {
		waitForElementVisible(driver, Admin_LoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, Admin_LoginPageUI.PASSWORD_TEXTBOX, password_Admin);

	}

	public AdminDashboardPageObject clicktoLoginButton() {
		waitForElementClick(driver, Admin_LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, Admin_LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}

	public AdminDashboardPageObject loginAsAdmin(String emailAddress_Admin, String password_Admin) {
		inputToEmailTextbox(emailAddress_Admin);
		inputToPasswordTextbox(password_Admin);
		return clicktoLoginButton();
	}
}
