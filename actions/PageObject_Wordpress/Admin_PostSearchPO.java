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

	public Admin_PostAddNewPO clickToPostTitleLink(String postTitle) {
		waitForElementClick(driver, Admin_postSearch_UI.TABLE_ROW_TITLE_DETAIL, postTitle);
		clickToElement(driver, Admin_postSearch_UI.TABLE_ROW_TITLE_DETAIL, postTitle);
		return PageObject_Wordpress.PageGeneratorManager.w_getAdminPostAddNewPage(driver);
	}

	public void selectPostCheckboxByTitle(String editpostTitle) {
		waitForElementClick(driver, Admin_postSearch_UI.ROW_CHECKBOX_BY_POST_TITLE, editpostTitle);
		checkToDefaultCheckboxRadio(driver, Admin_postSearch_UI.ROW_CHECKBOX_BY_POST_TITLE, editpostTitle);

	}

	public void selectValueTextItemActionDropdown(String dropdownItem) {
		waitForElementClick(driver, Admin_postSearch_UI.ACTION_DROPDOWN, dropdownItem);
		selectItemInDefaultDropdown(driver, Admin_postSearch_UI.ACTION_DROPDOWN, dropdownItem);

	}

	public void clickToAppLyButton() {
		waitForElementClick(driver, Admin_postSearch_UI.APPLY_DROPDOWN);
		clickToElement(driver, Admin_postSearch_UI.APPLY_DROPDOWN);

	}

	public boolean isMoveToTrashMessageIsDisplayed(String message) {
		waitForAllElementVisible(driver, Admin_postSearch_UI.MOVE_TO_TRASH_MESSAGE, message);
		return isElementDisplayed(driver, Admin_postSearch_UI.MOVE_TO_TRASH_MESSAGE, message);
	}

	public boolean isNoPostFoundMessageIsDisplayed(String message) {
		waitForAllElementVisible(driver, Admin_postSearch_UI.NOTHING_NOT_FOUND_MESSAGE, message);
		return isElementDisplayed(driver, Admin_postSearch_UI.NOTHING_NOT_FOUND_MESSAGE, message);
	}

}
