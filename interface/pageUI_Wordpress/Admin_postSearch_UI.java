package pageUI_Wordpress;

public class Admin_postSearch_UI {
	public static final String ADD_NEW_POST_BUTTON = "css=a.page-title-action";
	public static final String SEARCH_TEXTBOX = "css=input#post-search-input";
	public static final String SEARCHPOST_BUTTON = "css=input#search-submit";
	public static final String TABLE_HEADER_INDEX_BY_HEADER_NAME = "XPATH=//table[contains(@class,'table-view-list posts')]//thead//th[@id='title']/preceding-sibling::*";
	public static final String TABLE_ROW_VALUE_BY_HEADER_INDEX = "XPATH=//table[contains(@class,'table-view-list posts')]//tbody/tr/*[%s]//a[text()='%s']";

}
