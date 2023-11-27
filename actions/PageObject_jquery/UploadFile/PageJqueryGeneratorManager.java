package PageObject_jquery.UploadFile;

import org.openqa.selenium.WebDriver;

public class PageJqueryGeneratorManager {
	public static HomePageJqueryObject getHomePageJquery(WebDriver driver) {
		return new HomePageJqueryObject(driver);
	}
}
