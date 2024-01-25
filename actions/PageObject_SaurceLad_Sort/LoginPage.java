package PageObject_SaurceLad_Sort;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class LoginPage extends BasePage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void entertoUserNametextbox(String userName) {
		waitForElementVisible(driver, Login_P_UI.USERNAME_TEXTBOX);
		senkeyToElement(driver, Login_P_UI.USERNAME_TEXTBOX, userName);

	}

	public void entertoPassWordtextbox(String passWord) {
		waitForElementVisible(driver, Login_P_UI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, Login_P_UI.PASSWORD_TEXTBOX, passWord);

	}

	public ProductPage clickLoginButton() {
		waitForElementClick(driver, Login_P_UI.LOGIN_BUTTON);
		clickToElement(driver, Login_P_UI.LOGIN_BUTTON);
		return PageGeneratorManager.getProductPage(driver);
	}

}
