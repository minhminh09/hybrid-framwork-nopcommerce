package PageObjectLiveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI_LiveGuru.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToFirtNameTextbox(String firtName) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firtName);

	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);

	}

	public void inputToEmailNameTextbox(String emailAddress) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ADDRES_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.EMAIL_ADDRES_TEXTBOX, emailAddress);

	}

	public void inputToPassWordNameTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASS_WORD_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.PASS_WORD_TEXTBOX, password);

	}

	public void inputToConfirmPassWordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASS_WORDTEXTBOX);
		senkeyToElement(driver, RegisterPageUI.CONFIRM_PASS_WORDTEXTBOX, password);

	}

	public void clickToRegisterButton() {
		waitForElementClick(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);

	}

}
