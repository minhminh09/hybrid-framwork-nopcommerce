package com.facebook.register;

import org.testng.annotations.Test;

import PageObject_Facebook.LoginPageObject;
import PageObject_Facebook.PageGeneratorManager;
import commons.BaseTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_12_Element_Undisplay extends BaseTest {
	private LoginPageObject loginPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginFacebookPage(driver);
	}

	@Test
	public void TC_01_Verify_Element_Display() {
		loginPage.clickToCreatNewAccountButton();
		// nếu 1 hàm chỉ mong đợi Element Display thôi - thì sẽ kết hợp cả wait + isDisplay
		// waitForElementVisible
		// isElementDisplay
		verifyTrue(loginPage.isEmailAdressTextboxDisplay());

	}

	@Test
	public void TC_01_Verify_Element_UnDisplay() {
		// nếu mong đợi 1 hàm trả về vừa verify Element Display / undisplay thì không thể kết hợp wait
		// isElementDisplay

		// verifyTrue - mong đợi confirm email display
		loginPage.enterToEmailTextbox("automation@gmail.com");
		loginPage.sleepInsecon(2);
		verifyTrue(loginPage.isConfirmEmailTextboxDisplay());

		// verifyFalse - mong đợi confirm email undisplay
		// check confirm email textbox khong hien thi tren HTML nhung co trong DOM
		loginPage.enterToEmailTextbox("");
		loginPage.sleepInsecon(2);
		verifyFalse(loginPage.isConfirmEmailTextboxDisplay());

	}

	public void TC_01_Verify_Element_UnDisplay_Not_In_DOM() {
		loginPage.clickCloseIconResterForm();

	}

	@Test
	public void TC_04_Enter_To_Textbox_At_Any_Row() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;

}
