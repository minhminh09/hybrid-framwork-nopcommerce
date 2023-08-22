package PageObjectLiveGuru;

import org.openqa.selenium.WebDriver;

import PageUI_LiveGuru.LoginPageUI;
import commons.BasePage;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {

		this.driver = driver;
	}

	public void clickToCreatAnAccountButton() {
		waitForElementVisible(driver, LoginPageUI.CREAT_AN_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREAT_AN_ACCOUNT_BUTTON);
	}

	public void inputToEmailNameTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);

	}

	public void inputToPassWordNameTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASS_WORD_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.PASS_WORD_TEXTBOX, password);

	}

	public LoginPageObject clickToLoginButton() {
		waitForElementClick(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return new LoginPageObject(driver);
	}

}
