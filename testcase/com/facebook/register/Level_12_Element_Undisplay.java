package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject_Facebook.LoginPageObject;
import PageObject_Facebook.PageGeneratorManager;
import commons.BaseTest;

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
	public void TC_02_Verify_Element_UnDisplay() {
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
		// verifyFalse(loginPage.isConfirmEmailTextboxDisplay());
		verifyTrue(loginPage.isConfirmEmailTextboxUnDisplay());

	}

	@Test
	public void TC_03_Verify_Element_UnDisplay_Not_In_DOM() {
		loginPage.clickCloseIconRegisterForm();
		loginPage.sleepInsecon(2);
		// Khi close form Register thì confirm Email không có trong Dom
		// Nên hàm findElement sẽ bị fail vì không tìm thấy Element
		// 1- Nó sẽ chờ hết timeout của implicit: 30s
		// 2- Nó sẽ đánh fail testcase tại đúng step này
		// 3- Không có chạy các step còn lại

		// Verify false - mong đợi confirmEmail unDisplay (false)
		// isDisplayed - bản chất ko kiểm tra được 1 element không có trong DOM được
		// verifyFalse(loginPage.isConfirmEmailTextboxDisplay());
		verifyTrue(loginPage.isConfirmEmailTextboxUnDisplay());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;

}
