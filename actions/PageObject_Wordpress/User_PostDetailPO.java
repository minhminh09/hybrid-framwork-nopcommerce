package PageObject_Wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI_Wordpress.User_PostDetail_UI;
import pageUI_Wordpress.User_home_UI;

public class User_PostDetailPO extends BasePage {
	WebDriver driver;

	public User_PostDetailPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPostInforisDisplayed(String postTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isPostInforDisplayed_POST_TITLE(String postTitle) {
		waitForElementVisible(driver, User_PostDetail_UI.POST_TITLE_TEXT, postTitle);
		return isElementDisplayed(driver, User_PostDetail_UI.POST_TITLE_TEXT, postTitle);
	}

	public boolean isPostInforDisplayed_POST_BODY(String postTitle, String postBody) {
		waitForElementVisible(driver, User_PostDetail_UI.BODY_TEXT_BY_POST_TITLE, postTitle, postBody);
		return isElementDisplayed(driver, User_PostDetail_UI.BODY_TEXT_BY_POST_TITLE, postTitle, postBody);
	}

	public boolean isPostInforDisplayed_POST_AUTHOR(String postTitle, String authorName) {
		waitForElementVisible(driver, User_PostDetail_UI.OUTHER_TEXT_BY_POST_TITLE, postTitle, authorName);
		return isElementDisplayed(driver, User_PostDetail_UI.OUTHER_TEXT_BY_POST_TITLE, postTitle, authorName);
	}

	public boolean iisPostInforDisplayed_POST_CURRENT_DAY(String postTitle, String currentDay) {
		waitForElementVisible(driver, User_PostDetail_UI.POST_CURRENT_DATE_TEXT_BY_POST_TITLE, postTitle, currentDay);
		return isElementDisplayed(driver, User_PostDetail_UI.POST_CURRENT_DATE_TEXT_BY_POST_TITLE, postTitle, currentDay);
	}

}
