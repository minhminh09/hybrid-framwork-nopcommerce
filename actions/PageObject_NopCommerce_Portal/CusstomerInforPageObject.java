package PageObject_NopCommerce_Portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs_NopCommerce.CusstomerInforPageUI;
import pageUIs_NopCommerce.HomePageUI;

public class CusstomerInforPageObject extends BasePage {
	private WebDriver driver;

	public CusstomerInforPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isMyaccountPageDisplay() {
		waitForAllElementVisible(driver, CusstomerInforPageUI.CUSSTOMER_INFOR_HEADER);
		return isElementDisplayed(driver, CusstomerInforPageUI.CUSSTOMER_INFOR_HEADER);
	}

}
