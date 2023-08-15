package PageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementClick(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);

	}

	public String getErrorMessageAtFirtNameTextBox() {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtLastNameTextBox() {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtEmailTextBox() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageAtPassWordTextBox() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtConfirmPassWordTextBox() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public void inputToFirtNameTextbox(String firtName) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firtName);

	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);

	}

	public void inputToEmailNameTextbox(String emailName) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailName);

	}

	public void inputToPassWordNameTextbox(String passWord) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, passWord);

	}

	public void inputToConfirmPassWordTextbox(String confirmPassWord) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD);
		senkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD, confirmPassWord);

	}

	public String getSussesfullMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISRER_SUSSCESFULL);
		return getElementText(driver, RegisterPageUI.REGISRER_SUSSCESFULL);
	}

	public void clickToLogoutLink() {
		waitForElementClick(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);

	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, RegisterPageUI.EXITING_EMAIL_ERROR_MASSEGE);
		return getElementText(driver, RegisterPageUI.EXITING_EMAIL_ERROR_MASSEGE);
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
