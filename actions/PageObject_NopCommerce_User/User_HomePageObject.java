package PageObject_NopCommerce_User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs_NopCommerce_User.User_HomePageUI;

public class User_HomePageObject extends BasePage {
	private WebDriver driver;

	public User_HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Navigate to Register page")
	public User_RegisterPageObject clickToRegisterLink() {
		waitForElementClick(driver, User_HomePageUI.REGISTER_LINK);
		clickToElement(driver, User_HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}

	@Step("Navigate to Login page")
	public User_LoginPageObject clickToLoginLink() {
		waitForElementClick(driver, User_HomePageUI.LOGIN_LINK);
		clickToElement(driver, User_HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);

	}

	@Step("Verify 'Login susscersfull' text to Display")
	public String getMessageCussfull() {
		waitForElementVisible(driver, User_HomePageUI.LOGIN_SUSSCESFULL);
		return getElementText(driver, User_HomePageUI.LOGIN_SUSSCESFULL);
	}

	@Step("Verify 'My account' link to Display")
	public boolean isMyAccountLinkDisplay() {
		waitForAllElementVisible(driver, User_HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, User_HomePageUI.MY_ACCOUNT_LINK);
	}

	public User_CusstomerInforPageObject openMyaccountPage() {
		// TODO Auto-generated method stub
		return null;
	}

	// public void clickToRegisterLink() {
	// waitForElementClick(driver, HomePageUI.REGISTER_LINK);
	// clickToElement(driver, HomePageUI.REGISTER_LINK);
	//
	// }

}
