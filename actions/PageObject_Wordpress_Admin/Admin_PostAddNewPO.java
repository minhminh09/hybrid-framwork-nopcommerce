package PageObject_Wordpress_Admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI_wordpress_admin.Admin_postAddnew_UI;

public class Admin_PostAddNewPO extends BasePage {
	WebDriver driver;

	public Admin_PostAddNewPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToAddNewPostTitle(String postTilevalue) {
		waitForAllElementVisible(driver, Admin_postAddnew_UI.ADD_TITLE_TEXTBOX);
		senkeyToElement(driver, Admin_postAddnew_UI.ADD_TITLE_TEXTBOX, postTilevalue);

	}

	public void enterToAddBodyPostTitle(String postBodyvalue) {
		// Truoc khi click
		waitForAllElementVisible(driver, Admin_postAddnew_UI.BODY_BUTTON);
		clickToElement(driver, Admin_postAddnew_UI.BODY_BUTTON);

		// sau khi click
		waitForElementVisible(driver, Admin_postAddnew_UI.BODY_TEXTBOX);
		senkeyToElement(driver, Admin_postAddnew_UI.BODY_TEXTBOX, postBodyvalue);

	}

	public void clickToPublistButton() {
		waitForElementClick(driver, Admin_postAddnew_UI.PUBLISH_BUTTON);
		clickToElement(driver, Admin_postAddnew_UI.PUBLISH_BUTTON);
	}

	public void clickToPRE_PublistButton() {
		waitForElementClick(driver, Admin_postAddnew_UI.PRE_PUBLISH_BUTTON);
		clickToElement(driver, Admin_postAddnew_UI.PRE_PUBLISH_BUTTON);

	}

	public boolean isPostPublishMessageIsDisplayed(String postPublishMessage) {
		waitForElementVisible(driver, Admin_postAddnew_UI.PUBLISH_MESSAGE, postPublishMessage);
		return isElementDisplayed(driver, Admin_postAddnew_UI.PUBLISH_MESSAGE, postPublishMessage);

	}

	public Admin_PostSearchPO searchPostPageUrl(String searchPostUrl) {
		openPageURL(driver, searchPostUrl);
		return PageGeneratorManager.w_getAdminPostSearchPage(driver);

	}

}
