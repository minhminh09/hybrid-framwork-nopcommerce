package pageUI_jQuery.DataTable;

public class HomePageUI {
	public static final String PAGINGNATION_PAGE_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']//a[text()='%s']";
	public static final String PAGINGNATION_PAGE_ACTIVE_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String INPUT_SEARCH_TEXTBOX = "xpath=//div[@class='qgrd-header-text' and text()='%s']//parent::div//following-sibling::input";
	public static final String TOTAL_PAGINATION = "css=ul.qgrd-pagination-ul>li.qgrd-pagination-page";
	public static final String PAGINATION_PAGE_BY_INDEX = "xpath=//ul[@class='qgrd-pagination-ul']/li[@class='qgrd-pagination-page'][%s]/a";
	public static final String ALL_ROW_EACH_PAGE = "xpath=//tbody//tr";

	// Index cái cột mà mình cần enter/click/select vào
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr/th[text()='%s']//preceding-sibling::th";
	public static final String TEXTBOX_BY_COLUMN_INDEX_END_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input";
	public static final String DROPDOWN_BY_COLUMN_INDEX_END_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]//select";
	public static final String BUTTON_LOAD_DATA = "css=button#load";
	public static final String CHECKBOX_BY_COLUMN_INDEX_END_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]//input[@type='checkbox']";

	public static final String ICON_NAME_BY_ROW_NUMBER = "XPATH=//tbody/tr[%s]//button[@title='%s']";
}
