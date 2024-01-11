package PageObject_Nopcommerce_Admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs_Nopcommerce_Admin.Admin_DashboardPageUI;

public class AdminDashboardPageObject extends BasePage {
	private WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {

		this.driver = driver;
	}

	public boolean isDashboardHeaderDisplay() {
		return isElementDisplayed(driver, Admin_DashboardPageUI.DASHBOARD_HEARDER);
	}

	public void clicktoPostMenuLink() {
		// TODO Auto-generated method stub

	}
}
