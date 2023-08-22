package PageObject_NopCommerce_Portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs_NopCommerce.HomePageUI;
import pageUIs_NopCommerce.LoginPageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementClick(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClick(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);

	}

	public String getMessageCussfull() {
		waitForElementVisible(driver, HomePageUI.LOGIN_SUSSCESFULL);
		return getElementText(driver, HomePageUI.LOGIN_SUSSCESFULL);
	}

	public boolean isMyAccountLinkDisplay() {
		waitForAllElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	// public void clickToRegisterLink() {
	// waitForElementClick(driver, HomePageUI.REGISTER_LINK);
	// clickToElement(driver, HomePageUI.REGISTER_LINK);
	//
	// }

}
