package PageObject_Wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUI_Wordpress.Admin_Dashboard_UI;

public class Admin_DashboardPO extends BasePage {
	WebDriver driver;

	public Admin_DashboardPO(WebDriver driver) {
		this.driver = driver;
	}

	public Admin_PostSearchPO clicktoPostMenuLink() {

		waitForElementClick(driver, Admin_Dashboard_UI.POST_MENU_LINK);
		clickToElement(driver, Admin_Dashboard_UI.POST_MENU_LINK);
		return PageObject_Wordpress.PageGeneratorManager.w_getAdminPostSearchPage(driver);

	}
}
