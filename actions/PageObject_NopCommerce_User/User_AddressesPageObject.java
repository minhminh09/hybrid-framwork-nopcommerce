package PageObject_NopCommerce_User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs_NopCommerce_User.User_AddressesPageUI;

public class User_AddressesPageObject extends BasePage {
	private WebDriver driver;

	public User_AddressesPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
