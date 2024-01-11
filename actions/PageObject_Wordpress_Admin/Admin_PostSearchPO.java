package PageObject_Wordpress_Admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUI_wordpress_admin.Admin_postSearch_UI;

public class Admin_PostSearchPO extends BasePage {
	WebDriver driver;

	public Admin_PostSearchPO(WebDriver driver) {
		this.driver = driver;
	}

	public Admin_PostAddNewPO clicktoAddNewPostButton() {
		waitForElementClick(driver, Admin_postSearch_UI.ADD_NEW_POST_BUTTON);
		clickToElement(driver, Admin_postSearch_UI.ADD_NEW_POST_BUTTON);
		return PageObject_Wordpress_Admin.PageGeneratorManager.w_getAdminPostAddNewPage(driver);

	}
}
