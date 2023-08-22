package PageObject_NopCommerce_Portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs_NopCommerce.CusstomerInforPageUI;
import pageUIs_NopCommerce.LoginPageUI;
import pageUIs_NopCommerce.RegisterPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {

		this.driver = driver;
	}

	public HomePageObject clickToLogInButton() {
		waitForElementClick(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);

	}

	public void inputToEmailTextbox(String emailName) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailName);

	}

	public void inputToPassWordNameTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);

	}

	public String getErrorMessageEmailTextBox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	// public String getErrorMessageAtEmailTextBox() {
	// TODO Auto-generated method stub
	// return null;
	// }

	public String getErrorMessageUncussesfull() {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public CusstomerInforPageObject clickToMyAccoutLink() {
		waitForElementClick(driver, LoginPageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, LoginPageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getCusstomerInforPage(driver);

	}

}
