package PageObjectLiveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI_LiveGuru.DashboardPageUI;

public class DashboardPageObject extends BasePage {
	private WebDriver driver;

	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getMessageCussesfull() {
		waitForElementVisible(driver, DashboardPageUI.MY_ACCOUNT_LINK);
		return getElementText(driver, DashboardPageUI.MY_ACCOUNT_LINK);

	}
	//
	// public void clickToAccountLink() {
	// // TODO Auto-generated method stub
	//
	// }

	// public void clickToLogOutLink() {
	// // TODO Auto-generated method stub
	//
	// }

}
