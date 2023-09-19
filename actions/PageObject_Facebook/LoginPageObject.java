package PageObject_Facebook;

import org.openqa.selenium.WebDriver;

import PageUI_Facebook.pageUI_Facebook;
import commons.BasePage;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreatNewAccountButton() {
		waitForElementVisible(driver, pageUI_Facebook.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, pageUI_Facebook.CREATE_NEW_ACCOUNT_BUTTON);

	}

	public boolean isEmailAdressTextboxDisplay() {
		waitForElementVisible(driver, pageUI_Facebook.EMAIL_ADDRESS_TEXTBOX);
		return isElementDisplayed(driver, pageUI_Facebook.EMAIL_ADDRESS_TEXTBOX);
	}

	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, pageUI_Facebook.EMAIL_ADDRESS_TEXTBOX);
		senkeyToElement(driver, pageUI_Facebook.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}

	public boolean isConfirmEmailTextboxDisplay() {

		return isElementDisplayed(driver, pageUI_Facebook.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
	}

	public void clickCloseIconResterForm() {
		waitForElementVisible(driver, pageUI_Facebook.CLOSE_ICON_POPUP);
		clickToElement(driver, pageUI_Facebook.CLOSE_ICON_POPUP);

	}

	public boolean isConfirmEmailTextboxUnDisplay() {
		// waitForElementUnDisplayed(driver, pageUI_Facebook.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
		return isElementUndisplayed(driver, pageUI_Facebook.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
	}

	public void clickCloseIconRegisterForm() {
		waitForElementVisible(driver, pageUI_Facebook.CLOSE_ICON_POPUP);
		clickToElement(driver, pageUI_Facebook.CLOSE_ICON_POPUP);

	}

}