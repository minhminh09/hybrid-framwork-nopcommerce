package PageObject_NopCommerce_User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs_NopCommerce_User.User_LoginPageUI;

public class User_LoginPageObject extends BasePage {
	private WebDriver driver;

	public User_LoginPageObject(WebDriver driver) {

		this.driver = driver;
	}

	@Step("Click to logout button")
	public User_HomePageObject clickToLogInButton() {
		waitForElementClick(driver, User_LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, User_LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);

	}

	@Step("Enter to emailAddress textbox with value is {0}")
	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, User_LoginPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, User_LoginPageUI.EMAIL_TEXTBOX, emailAddress);

	}

	@Step("Enter to password textbox with value is {0}")
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

	@Step("Click to My account link")
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
