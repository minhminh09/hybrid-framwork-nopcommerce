package PageObject_NopCommerce_User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs_NopCommerce_User.User_CusstomerInforPageUI;

public class User_CusstomerInforPageObject extends BasePage {
	private WebDriver driver;

	public User_CusstomerInforPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Verify Customer page is Display")
	public boolean isMyaccountPageDisplay() {
		waitForAllElementVisible(driver, User_CusstomerInforPageUI.CUSSTOMER_INFOR_HEADER);
		return isElementDisplayed(driver, User_CusstomerInforPageUI.CUSSTOMER_INFOR_HEADER);
	}

}
