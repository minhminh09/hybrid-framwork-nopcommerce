package PageObject_NopCommerce_User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs_NopCommerce_User.User_AddressesPageUI;
import pageUIs_NopCommerce_User.User_MyProductReviewsPageUI;

public class User_MyProductReviewsPageObject extends BasePage {
	private WebDriver driver;

	public User_MyProductReviewsPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
