package PageObject_Facebook;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static LoginPageObject getLoginFacebookPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
}
