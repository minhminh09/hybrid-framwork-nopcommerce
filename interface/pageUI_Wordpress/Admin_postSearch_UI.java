package pageUI_Wordpress;

public class Admin_postSearch_UI {
	public static final String ADD_NEW_POST_BUTTON = "css=a.page-title-action";
	public static final String SEARCH_TEXTBOX = "css=input#post-search-input";
	public static final String SEARCHPOST_BUTTON = "css=input#search-submit";
	public static final String TABLE_HEADER_INDEX_BY_HEADER_NAME = "XPATH=//table[contains(@class,'table-view-list posts')]//thead//th[@id='title']/preceding-sibling::*";
	public static final String TABLE_ROW_VALUE_BY_HEADER_INDEX = "XPATH=//table[contains(@class,'table-view-list posts')]//tbody/tr/*[%s]//a[text()='%s']";
	public static final String TABLE_ROW_TITLE_DETAIL = "XPATH=//table[contains(@class,'table-view-list posts')]/tbody/tr//a[@class='row-title' and text()='%s']";
	public static final String ROW_CHECKBOX_BY_POST_TITLE = "xpath=//table[contains(@class,'table-view-list posts')]/tbody/tr//a[@class='row-title' and text()='%s']/ancestor::td/preceding-sibling::th/input";
	public static final String ACTION_DROPDOWN = "css=select#bulk-action-selector-top";
	public static final String APPLY_DROPDOWN = "css=input#doaction";
	public static final String MOVE_TO_TRASH_MESSAGE = "xpath=//div[@id='message']/p[contains(text(),'%s')]";
	public static final String NOTHING_NOT_FOUND_MESSAGE = "xpath=//table[contains(@class,'able-view-list posts')]//tbody/tr[@class='no-items']/td[text()='%s']";

}
