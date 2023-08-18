package PageFactory_NopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePageFactory {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='FirstName']")
	private WebElement firstNameTextbox;

	@FindBy(id = "LastName")
	private WebElement lastNameTextbox;

	@FindBy(id = "Email")
	private WebElement emailTextbox;

	@FindBy(xpath = "//input[@id='Password']")
	private WebElement pastwordTextbox;

	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	private WebElement confirmPassword;

	@FindBy(xpath = "//button[@id='register-button']")
	private WebElement registerButton;

	@FindBy(xpath = "//span[@id='FirstName-error']")
	private WebElement firstNameErrorMessage;

	@FindBy(xpath = "//span[@id='LastName-error']")
	private WebElement lastNameErrorMessage;

	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement emailErrorMessage;

	@FindBy(xpath = "//span[@id='Password-error']")
	private WebElement passwordErrorMessage;

	@FindBy(xpath = "//span[@id='ConfirmPassword-error']")
	private WebElement confirmPassWordErrorMessage;

	@FindBy(xpath = "//div[@class='result']")
	private WebElement registerCussesfull;

	@FindBy(xpath = "//a[@class='ico-login']")
	private WebElement logoutLink;

	@FindBy(xpath = "//span[@id='ConfirmPassword-error']")
	private WebElement exitingEmailErrorMessage;

	public void clickToRegisterButton() {
		waitForElementClick(driver, registerButton);
		clickToElement(driver, registerButton);

	}

	public String getErrorMessageAtFirtNameTextBox() {
		waitForElementVisible(driver, firstNameErrorMessage);
		return getElementText(driver, firstNameErrorMessage);
	}

	public String getErrorMessageAtLastNameTextBox() {
		waitForElementVisible(driver, lastNameErrorMessage);
		return getElementText(driver, lastNameErrorMessage);
	}

	public String getErrorMessageAtEmailTextBox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public String getErrorMessageAtPassWordTextBox() {
		waitForElementVisible(driver, passwordErrorMessage);
		return getElementText(driver, passwordErrorMessage);
	}

	public String getErrorMessageAtConfirmPassWordTextBox() {
		waitForElementVisible(driver, confirmPassWordErrorMessage);
		return getElementText(driver, confirmPassWordErrorMessage);
	}

	public void inputToFirtNameTextbox(String firtName) {
		waitForElementVisible(driver, firstNameTextbox);
		senkeyToElement(driver, firstNameTextbox, firtName);

	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, lastNameTextbox);
		senkeyToElement(driver, lastNameTextbox, lastName);

	}

	public void inputToEmailNameTextbox(String emailName) {
		waitForElementVisible(driver, emailTextbox);
		senkeyToElement(driver, emailTextbox, emailName);

	}

	public void inputToPassWordNameTextbox(String passWord) {
		waitForElementVisible(driver, pastwordTextbox);
		senkeyToElement(driver, pastwordTextbox, passWord);

	}

	public void inputToConfirmPassWordTextbox(String confirmPassWord) {
		waitForElementVisible(driver, confirmPassword);
		senkeyToElement(driver, confirmPassword, confirmPassWord);

	}

	public String getSussesfullMessage() {
		waitForElementVisible(driver, registerCussesfull);
		return getElementText(driver, registerCussesfull);
	}

	public void clickToLogoutLink() {
		waitForElementClick(driver, logoutLink);
		clickToElement(driver, logoutLink);

	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, exitingEmailErrorMessage);
		return getElementText(driver, exitingEmailErrorMessage);
	}

}
