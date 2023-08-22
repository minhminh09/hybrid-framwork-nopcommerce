package PageObject_NopCommerce_Portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs_NopCommerce.AddressesPageUI;

public class AddressesPageObject extends BasePage {
	private WebDriver driver;

	public AddressesPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
