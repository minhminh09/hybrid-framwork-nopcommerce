package PageObject_jquery.UploadFile;

import org.openqa.selenium.WebDriver;

import PageObject_jquery.DataTable.HomePageObject;

public class PageJqueryGeneratorManager {
	public static HomePageJqueryObject getHomePageJquery(WebDriver driver) {
		return new HomePageJqueryObject(driver);
	}
}
