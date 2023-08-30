package PageObjectLiveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI_LiveGuru.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public HomePageObject clickToMyAccountLink() {
		waitForElementClick(driver, HomePageUI.MY_ACCOUT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUT_LINK);
		return new HomePageObject(driver);

	}

	public HomePageObject clickToAccountLink() {
		waitForElementClick(driver, HomePageUI.ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.ACCOUNT_LINK);
		return new HomePageObject(driver);

	}

	public HomePageObject clickToLogInLink() {
		waitForElementClick(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return new HomePageObject(driver);

	}

	public HomePageObject clickToLogOutLink() {
		waitForElementClick(driver, HomePageUI.LOGOUT_LINK);
		clickToElement(driver, HomePageUI.LOGOUT_LINK);
		return new HomePageObject(driver);

	}

}
