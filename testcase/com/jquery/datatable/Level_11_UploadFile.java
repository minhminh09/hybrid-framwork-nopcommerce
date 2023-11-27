package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject_jquery.UploadFile.HomePageJqueryObject;
import PageObject_jquery.UploadFile.PageJqueryGeneratorManager;
import commons.BaseTest;

public class Level_11_UploadFile extends BaseTest {
	private HomePageJqueryObject homePage;
	String autotestingFileName = "autotesting.png";
	String manualtestingFileName = "manualtesting.png";
	String typeAutotestingFileName = "TypeAutotesting.png";
	String[] multipleFileName = { autotestingFileName, manualtestingFileName, typeAutotestingFileName };

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {

		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageJqueryGeneratorManager.getHomePageJquery(driver);
	}

	@Test
	public void Upload_01_One_File_Per_Time() {
		// Step 1: Load 1 file
		homePage.uploadfileMultipleFile(driver, autotestingFileName);
		// step2: Verify file upload succesfull
		Assert.assertTrue(homePage.isFileLoadedByName(autotestingFileName));
		// Step 3: click button Start
		homePage.clickToStartButton();
		// Step 4: verify link file hien thi
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(autotestingFileName));
		// Step 5: verify image hien thi
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(autotestingFileName));
	}

	@Test
	public void Upload_01_Multiple_File_Per_Time() {
		// Step 1: Load 1 file
		homePage.uploadfileMultipleFile(driver, multipleFileName);

		// step2: Verify file upload succesfull
		Assert.assertTrue(homePage.isFileLoadedByName(autotestingFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(manualtestingFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(typeAutotestingFileName));

		// Step 3: click button Start
		homePage.clickToStartButton();
		// Step 4: verify link file hien thi
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(autotestingFileName));
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(manualtestingFileName));
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(typeAutotestingFileName));
		// Step 5: verify image hien thi
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(autotestingFileName));
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(manualtestingFileName));
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(typeAutotestingFileName));
	}

	public void TC_03_Enter_To_Header() {

	}

	@Test
	public void TC_04_Enter_To_Textbox_At_Any_Row() {

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

	private WebDriver driver;

}
