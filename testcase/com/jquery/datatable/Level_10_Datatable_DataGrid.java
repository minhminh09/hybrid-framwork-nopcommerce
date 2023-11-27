package com.jquery.datatable;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject_jquery.DataTable.HomePageObject;
import commons.BaseTest;

public class Level_10_Datatable_DataGrid extends BaseTest {
	private HomePageObject homePage;
	List<String> actualAllCountryValue;
	List<String> expectedAllCountryValue;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {

		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageObject_jquery.DataTable.PageGeneratorManager.getHomePage(driver);
	}

	public void TC_01_Paging() {
		homePage.openPagingByPageNumber("10");
		homePage.sleepInsecon(1);
		Assert.assertTrue(homePage.isPageNumbetActive("10"));

		homePage.openPagingByPageNumber("20");
		homePage.sleepInsecon(1);
		Assert.assertTrue(homePage.isPageNumbetActive("20"));

		homePage.openPagingByPageNumber("7");
		homePage.sleepInsecon(1);
		Assert.assertTrue(homePage.isPageNumbetActive("7"));

		homePage.openPagingByPageNumber("15");
		homePage.sleepInsecon(1);
		Assert.assertTrue(homePage.isPageNumbetActive("15"));

	}

	public void TC_02_Enter_To_Header() {
		homePage.refreshCurrentPage(driver);
		homePage.enterToHeaderTextboxByLabel("Country", "Vietnam");
		homePage.enterToHeaderTextboxByLabel("Females", "642000");
		homePage.enterToHeaderTextboxByLabel("Males", "678000");
		homePage.enterToHeaderTextboxByLabel("Total", "1320000");
		homePage.sleepInsecon(3);
		homePage.enterToHeaderTextboxByLabel("Country", "Vietnam");
	}

	public void TC_03_Enter_To_Header() {
		actualAllCountryValue = homePage.getValueEachRowAtAllPage();
		Assert.assertEquals(actualAllCountryValue, expectedAllCountryValue);
	}

	@Test
	public void TC_04_Enter_To_Textbox_At_Any_Row() {
		homePage.clickToLoadButton();
		homePage.sleepInsecon(2);
		// điều giá trị và các ô trong hàng
		// homePage.enterToTextboxByColumnNameAtRowNumber("Company", "1", "AutomationFC");
		// homePage.sleepInsecon(2);
		//
		// homePage.enterToTextboxByColumnNameAtRowNumber("Contact Person", "2", "Michael 97");
		// homePage.sleepInsecon(2);
		//
		// homePage.enterToTextboxByColumnNameAtRowNumber("Order Placed", "3", "2");
		// homePage.sleepInsecon(2);
		//
		// homePage.selectDropownByColumnNameAtRowNumber("Country", "4", "Japan");
		// homePage.sleepInsecon(2);
		//
		// homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "2");
		// homePage.sleepInsecon(2);
		//
		// homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "3");
		// homePage.sleepInsecon(2);
		//
		// homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?", "1");
		// homePage.sleepInsecon(2);
		//
		// homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?", "4");
		// homePage.sleepInsecon(2);
		//
		// homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?", "5");
		// homePage.sleepInsecon(2);

		// insert, remove, move up, move down dòng trong bảng
		homePage.clickToIconByRowNumber("1", "Insert Row Above");
		homePage.sleepInsecon(2);
		homePage.clickToIconByRowNumber("1", "Remove Current Row");
		homePage.sleepInsecon(4);
		homePage.clickToIconByRowNumber("4", "Move Up");
		homePage.sleepInsecon(2);

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

	private WebDriver driver;

}
