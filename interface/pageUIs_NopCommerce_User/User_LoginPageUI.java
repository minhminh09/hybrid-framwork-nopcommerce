package pageUIs_NopCommerce_User;

public class User_LoginPageUI {

	public static final String EMAIL_TEXTBOX = "xpath=//input[@class='email']";
	public static final String PASSWORD_TEXTBOX = "xpath=//input[@class='password']";
	public static final String LOGIN_BUTTON = "xpath=//button[contains(@class,'login-button')]";
	public static final String EMAIL_ERROR_MESSAGE = "xpath=//span[@id='Email-error']";// email emty and email invalid
	public static final String PASSWORD_ERROR_MESSAGE = "xpath=//div[contains(@class,'message-error')]";// email chưa đăng ký, password nhập sai
	public static final String MY_ACCOUNT_LINK = "xpath=//ul [@class='list']//a [text()='My account']";

}
