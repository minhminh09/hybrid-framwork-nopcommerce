package PageObject_NopCommerce_User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs_NopCommerce_User.User_RegisterPageUI;

public class User_RegisterPageObject extends BasePage {
	private WebDriver driver;

	public User_RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementClick(driver, User_RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, User_RegisterPageUI.REGISTER_BUTTON);

	}

	public String getErrorMessageAtFirtNameTextBox() {
		waitForElementVisible(driver, User_RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, User_RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtLastNameTextBox() {
		waitForElementVisible(driver, User_RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, User_RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtEmailTextBox() {
		waitForElementVisible(driver, User_RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, User_RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageAtPassWordTextBox() {
		waitForElementVisible(driver, User_RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, User_RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtConfirmPassWordTextBox() {
		waitForElementVisible(driver, User_RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, User_RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public void inputToFirtNameTextbox(String firtName) {
		waitForElementVisible(driver, User_RegisterPageUI.FIRST_NAME_TEXTBOX);
		senkeyToElement(driver, User_RegisterPageUI.FIRST_NAME_TEXTBOX, firtName);

	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, User_RegisterPageUI.LAST_NAME_TEXTBOX);
		senkeyToElement(driver, User_RegisterPageUI.LAST_NAME_TEXTBOX, lastName);

	}

	public void inputToEmailNameTextbox(String emailName) {
		waitForElementVisible(driver, User_RegisterPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, User_RegisterPageUI.EMAIL_TEXTBOX, emailName);

	}

	public void inputToPassWordNameTextbox(String passWord) {
		waitForElementVisible(driver, User_RegisterPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, User_RegisterPageUI.PASSWORD_TEXTBOX, passWord);

	}

	public void inputToConfirmPassWordTextbox(String confirmPassWord) {
		waitForElementVisible(driver, User_RegisterPageUI.CONFIRM_PASSWORD);
		senkeyToElement(driver, User_RegisterPageUI.CONFIRM_PASSWORD, confirmPassWord);

	}

	public String getSussesfullMessage() {
		waitForElementVisible(driver, User_RegisterPageUI.REGISRER_SUSSCESFULL);
		return getElementText(driver, User_RegisterPageUI.REGISRER_SUSSCESFULL);
	}

	public User_HomePageObject clickToLogoutLink() {
		waitForElementClick(driver, User_RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, User_RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);

	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, User_RegisterPageUI.EXITING_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, User_RegisterPageUI.EXITING_EMAIL_ERROR_MESSAGE);
	}

	// public String getErrorMessageAtPassWord() {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// public String getErrorMessageAtConfirmPassWord() {
	// // TODO Auto-generated method stub
	// return null;
	// }

}
