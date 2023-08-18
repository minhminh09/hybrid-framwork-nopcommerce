package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {
	private long longTimeOut = 50;

	public void getPageURL(WebDriver driver, String pageURL) {
		driver.get(pageURL);

	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();

	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();

	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();

	}

	public void refreshToPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitwait = new WebDriverWait(driver, longTimeOut);
		return explicitwait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void senkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}

	public void switchToWindownByID(WebDriver driver, String windownID) {
		Set<String> allWindownIDs = driver.getWindowHandles();
		for (String id : allWindownIDs) {
			if (!id.equals(allWindownIDs)) {
				driver.switchTo().window(id);
				break;

			}

		}
	}

	public void switchToWindownByTitle(WebDriver driver, String tabTitle) {
		Set<String> allWindownIDs = driver.getWindowHandles();
		for (String id : allWindownIDs) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();
			if (actualTitle.equals(tabTitle)) {
				break;
			}

		}
	}

	public void closeAllTabWithOutParent(WebDriver driver, String parentID) {
		Set<String> allWindownIDs = driver.getWindowHandles();
		for (String id : allWindownIDs) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
			driver.switchTo().window(parentID);
		}
	}

	public void waitForElementVisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForAllElementVisible(WebDriver driver, List<WebElement> elements) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	public void waitForElementInvisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void waitForAllElementInvisible(WebDriver driver, List<WebElement> elements) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}

	public void waitForElementClick(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}

	public void senkeyToElement(WebDriver driver, WebElement element, String textvalue) {

		element.clear();
		element.sendKeys(textvalue);
	}

	public String getElementText(WebDriver driver, WebElement element) {
		return element.getText();
	}

	public boolean isElementDisplayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}

}
