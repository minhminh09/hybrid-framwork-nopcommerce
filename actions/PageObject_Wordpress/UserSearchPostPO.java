package PageObject_Wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI_Wordpress.UserSearchPostUI;

public class UserSearchPostPO extends BasePage {
	WebDriver driver;

	public UserSearchPostPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isNothingFoundMessageDisplayed(String message) {
		waitForElementVisible(driver, UserSearchPostUI.NOTHING_FOUND_MESSAGE, message);
		return isElementDisplayed(driver, UserSearchPostUI.NOTHING_FOUND_MESSAGE, message);
	}
}
