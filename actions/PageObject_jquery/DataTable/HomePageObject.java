package PageObject_jquery.DataTable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.interactions.SendKeyToActiveElement;

import commons.BasePage;
import pageUI_jQuery.DataTable.HomePageUI;

public class HomePageObject<WebElement> extends BasePage {
	private WebDriver driver;
	private char[] index;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClick(driver, HomePageUI.PAGINGNATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINGNATION_PAGE_BY_NUMBER, pageNumber);

	}

	public void enterToHeaderTextboxByLabel(String headerLabel, String values) {
		waitForElementVisible(driver, HomePageUI.INPUT_SEARCH_TEXTBOX, headerLabel);
		senkeyToElement(driver, HomePageUI.INPUT_SEARCH_TEXTBOX, values, headerLabel);
		pressKeyToElement(driver, HomePageUI.INPUT_SEARCH_TEXTBOX, Keys.ENTER, headerLabel);

	}

	public void refreshCurrentPage(WebDriver driver2) {
		// TODO Auto-generated method stub

	}

	public boolean isPageNumbetActive(String pageName) {
		waitForElementVisible(driver, HomePageUI.PAGINGNATION_PAGE_ACTIVE_BY_NUMBER, pageName);
		return isElementDisplayed(driver, HomePageUI.PAGINGNATION_PAGE_ACTIVE_BY_NUMBER, pageName);
	}

	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);
		System.out.println("Total size=" + totalPage);

		List<String> allRowValueAllPage = new ArrayList<String>();

		// Duyệt qua tất cả các page number (paging)
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_INDEX, String.valueOf(index));

			// Get text của all row mỗi page đưa ra ArrayList
			List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_EACH_PAGE);
			for (WebElement eachRow : allRowElementEachPage) {
				// allRowValueAllPage.add(eachRoxt);

			}
		}
		// In tat ca cac gia tri row ra - tat ca cac page
		for (String value : allRowValueAllPage) {
			System.out.println("---------------");
			System.out.println(value);
		}
		return allRowValueAllPage;
	}

	public void enterToTextboxByColumnNameAtRowNumber(String columnName, String rowNumber, String valueEnter) {
		// colum index dựa vào tên cột
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		// senkey vào dòng nào
		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_END_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		senkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_END_ROW_INDEX, valueEnter, rowNumber, String.valueOf(columnIndex));
	}

	public void selectDropownByColumnNameAtRowNumber(String columnName, String rowNumber, String valueSelect) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClick(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_END_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		selectItemInDefaultDropdown(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_END_ROW_INDEX, valueSelect, rowNumber, String.valueOf(columnIndex));

	}

	public void clickToLoadButton() {
		waitForElementClick(driver, HomePageUI.BUTTON_LOAD_DATA);
		clickToElement(driver, HomePageUI.BUTTON_LOAD_DATA);

	}

	public void checkToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClick(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_END_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		checkToDefaultCheckboxRadio(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_END_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
	}

	public void uncheckToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClick(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_END_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		uncheckToDefaultCheckbox(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_END_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
	}

	public void clickToIconByRowNumber(String rowNumber, String iconName) {
		waitForElementClick(driver, HomePageUI.ICON_NAME_BY_ROW_NUMBER, rowNumber, iconName);
		clickToElement(driver, HomePageUI.ICON_NAME_BY_ROW_NUMBER, rowNumber, iconName);

	}

}
