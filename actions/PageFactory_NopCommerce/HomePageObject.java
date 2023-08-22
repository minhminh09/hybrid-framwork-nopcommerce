package PageFactory_NopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUIs_NopCommerce.HomePageUI;

public class HomePageObject extends BasePageFactory {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a [@class='ico-register']")
	private WebElement registerLink;

	@FindBy(xpath = "//a[@class='ico-login']")
	private WebElement loginLink;

	@FindBy(css = "a[class='ico-account']")
	private WebElement myaccountLink;

	public void clickToRegisterLink() {
		waitForElementClick(driver, registerLink);
		clickToElement(driver, registerLink);
	}

	public void clickToLoginLink() {
		waitForElementClick(driver, loginLink);
		clickToElement(driver, loginLink);

	}

	public String getMessageCussfull() {
		waitForElementVisible(driver, myaccountLink);
		return getElementText(driver, myaccountLink);
	}
}
