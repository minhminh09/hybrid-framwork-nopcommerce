package PageFactory_NopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePageFactory {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@class='email']")
	private WebElement emailTextbox;

	@FindBy(xpath = "//input[@class='password']")
	private WebElement passwordTextbox;

	@FindBy(xpath = "//button[contains(@class,'login-button')]")
	private WebElement loginButton;

	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement email_Error_Message;

	@FindBy(xpath = "//div[contains(@class,'message-error')]")
	private WebElement passWord_Error_Message;

	public void clickToLogInButton() {
		waitForElementClick(driver, loginButton);
		clickToElement(driver, loginButton);

	}

	public void inputToEmailTextbox(String emailName) {
		waitForElementVisible(driver, emailTextbox);
		senkeyToElement(driver, emailTextbox, emailName);

	}

	public void inputToPassWordNameTextbox(String password) {
		waitForElementVisible(driver, emailTextbox);
		senkeyToElement(driver, emailTextbox, password);

	}

	public String getErrorMessageEmailTextBox() {
		waitForElementVisible(driver, email_Error_Message);
		return getElementText(driver, email_Error_Message);
	}

	public String getErrorMessageUncussesfull() {
		waitForElementVisible(driver, passWord_Error_Message);
		return getElementText(driver, passWord_Error_Message);
	}

}
