package com.saurcelad.sort;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject_SaurceLad_Sort.LoginPage;
import PageObject_SaurceLad_Sort.PageGeneratorManager;
import PageObject_SaurceLad_Sort.ProductPage;
import commons.BaseTest;

@Listeners(org.uncommons.reportng.HTMLReporter.class)
public class Level_17_Sort_Acc_Desc extends BaseTest {

	@Parameters({ "browser", "appUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String sauceLadUrl) {

		driver = getBrowserDriver(browserName, sauceLadUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.entertoUserNametextbox("standard_user");
		loginPage.entertoPassWordtextbox("secret_sauce");
		productPage = loginPage.clickLoginButton();

	}

	@Test
	public void Sort_01_Name() {
		// sap xep tang dan tu A-Z
		productPage.selectItemProductSortDropdown("Name (A to Z)");
		productPage.sleepInsecon(3);

		Assert.assertTrue(productPage.isProductNameSortByAscending());

		// sap xep GIAM dan tu Z-A
		productPage.selectItemProductSortDropdown("Name (Z to A)");
		productPage.sleepInsecon(3);
		Assert.assertTrue(productPage.isProductNameSortByDescending());

	}

	@Test
	public void Sort_02_Price() {
		// sap xep tang dan tu Low - hight
		productPage.selectItemProductSortDropdown("Price (low to high)");
		productPage.sleepInsecon(3);

		Assert.assertTrue(productPage.isProductPriceSortByAscending());

		// sap xep GIAM dan tu hight-Low
		productPage.selectItemProductSortDropdown("Price (high to low)");
		productPage.sleepInsecon(3);
		Assert.assertTrue(productPage.isProductPriceSortByDescending());

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();

	}

	WebDriver driver;
	LoginPage loginPage;
	ProductPage productPage;
}
