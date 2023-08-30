package PageObject_NopCommerce_User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs_NopCommerce_User.User_CusstomerInforPageUI;
import pageUIs_NopCommerce_User.User_LoginPageUI;
import pageUIs_NopCommerce_User.User_RegisterPageUI;

public class User_LoginPageObject extends BasePage {
	private WebDriver driver;

	public User_LoginPageObject(WebDriver driver) {

		this.driver = driver;
	}

	public User_HomePageObject clickToLogInButton() {
		waitForElementClick(driver, User_LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, User_LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);

	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, User_LoginPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, User_LoginPageUI.EMAIL_TEXTBOX, emailAddress);

	}

	public void inputToPassWordNameTextbox(String password) {
		waitForElementVisible(driver, User_LoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, User_LoginPageUI.PASSWORD_TEXTBOX, password);

	}

	public String getErrorMessageEmailTextBox() {
		waitForElementVisible(driver, User_LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, User_LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageUncussesfull() {
		waitForElementVisible(driver, User_LoginPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, User_LoginPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public User_CusstomerInforPageObject clickToMyAccoutLink() {
		waitForElementClick(driver, User_LoginPageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, User_LoginPageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCusstomerInforPage(driver);

	}

	public User_HomePageObject loginAsUser(String emailAddress, String password) {
		inputToEmailTextbox(emailAddress);
		inputToPassWordNameTextbox(password);
		return clickToLogInButton();
	}

}
