package PageObject_Wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUI_Wordpress.Admin_postSearch_UI;

public class Admin_PostSearchPO extends BasePage {
	WebDriver driver;

	public Admin_PostSearchPO(WebDriver driver) {
		this.driver = driver;
	}

	public Admin_PostAddNewPO clicktoAddNewPostButton() {
		waitForElementClick(driver, Admin_postSearch_UI.ADD_NEW_POST_BUTTON);
		clickToElement(driver, Admin_postSearch_UI.ADD_NEW_POST_BUTTON);
		return PageObject_Wordpress.PageGeneratorManager.w_getAdminPostAddNewPage(driver);

	}

	public void enterToSearchTextbox(String postTitle) {
		waitForElementVisible(driver, Admin_postSearch_UI.SEARCH_TEXTBOX);
		senkeyToElement(driver, Admin_postSearch_UI.SEARCH_TEXTBOX, postTitle);

	}

	public void clickToSearchPostButton() {
		waitForElementClick(driver, Admin_postSearch_UI.SEARCHPOST_BUTTON);
		clickToElement(driver, Admin_postSearch_UI.SEARCHPOST_BUTTON);

	}

	public boolean isPostSearchTableisDisplay(String headerID, String cellvalue) {
		int headerIndex = getElementSize(driver, Admin_postSearch_UI.TABLE_HEADER_INDEX_BY_HEADER_NAME, headerID) + 1;
		waitForElementVisible(driver, Admin_postSearch_UI.TABLE_HEADER_INDEX_BY_HEADER_NAME, String.valueOf(headerIndex), cellvalue);
		return isElementDisplayed(driver, Admin_postSearch_UI.TABLE_HEADER_INDEX_BY_HEADER_NAME, String.valueOf(headerIndex), cellvalue);

	}

}
