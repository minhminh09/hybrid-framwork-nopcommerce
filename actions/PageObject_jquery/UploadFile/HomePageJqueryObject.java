package PageObject_jquery.UploadFile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI_jquery_UploadFile.HomePageUI;

public class HomePageJqueryObject extends BasePage {
	private WebDriver driver;

	public HomePageJqueryObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileLoadedByName(String fileName) {
		waitForAllElementVisible(driver, HomePageUI.FILE_NAME_LOADED, fileName);
		return isElementDisplayed(driver, HomePageUI.FILE_NAME_LOADED, fileName);
	}

	public boolean isFileLinkUpLoadedByName(String fileName) {
		waitForAllElementVisible(driver, HomePageUI.FILE_NAME_UPLOADED, fileName);
		return isElementDisplayed(driver, HomePageUI.FILE_NAME_UPLOADED, fileName);
	}

	public void clickToStartButton() {
		List<WebElement> startButtons = getListWebElement(driver, HomePageUI.START_BUTTON);
		for (WebElement startButton : startButtons) {
			startButton.click();
			sleepInsecon(2);
		}

	}

	public boolean isFileImageUpLoadedByName(String fileName) {
		waitForAllElementVisible(driver, HomePageUI.FILE_NAME_IMAGE_UPLOADED, fileName);
		return isImageLoaded(driver, HomePageUI.FILE_NAME_IMAGE_UPLOADED, fileName);

	}

}
