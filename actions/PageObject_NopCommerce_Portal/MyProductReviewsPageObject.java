package PageObject_NopCommerce_Portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs_NopCommerce.AddressesPageUI;
import pageUIs_NopCommerce.MyProductReviewsPageUI;

public class MyProductReviewsPageObject extends BasePage {
	private WebDriver driver;

	public MyProductReviewsPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
