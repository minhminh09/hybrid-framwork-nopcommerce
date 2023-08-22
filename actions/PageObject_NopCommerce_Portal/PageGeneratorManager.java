package PageObject_NopCommerce_Portal;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static CusstomerInforPageObject getCusstomerInforPage(WebDriver driver) {
		return new CusstomerInforPageObject(driver);
	}

	public static AddressesPageObject getAddressesPage(WebDriver driver) {
		return new AddressesPageObject(driver);
	}

	public static RewardPointsPageObject getRewardPoitsPage(WebDriver driver) {
		return new RewardPointsPageObject(driver);
	}

	public static MyProductReviewsPageObject getMyProductReviewPage(WebDriver driver) {
		return new MyProductReviewsPageObject(driver);
	}

}
