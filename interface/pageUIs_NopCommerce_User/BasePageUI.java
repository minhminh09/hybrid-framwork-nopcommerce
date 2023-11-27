package pageUIs_NopCommerce_User;

public class BasePageUI {
	public static final String ADDRESS_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static final String REWARD_POINT_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
	public static final String MY_PRODUCT_REVIEW_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";
	public static final String CUSTOMER_INFO_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Customer info']";

	public static final String LOGIN_LINK = "xpath=//a[@class='ico-login']";
	public static final String LOGOUT_LINK_USER = "xpath=//a[@class='ico-logout']";
	public static final String LOGOUT_LINK_ADMIN = "xpath=//a[text()='Logout']";
	public static final String REGISTER_LINK = "xpath=//a[@class='ico-register']";

	// pattern object
	public static final String DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA = "xpath=//div[contains(@class,'account-navigation')]//a[text()='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_TEXT = "xpath=//button[text()='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[@name='%s']";
	public static final String DYNAMIC_RADIO_BUTTON_BY_LABEL = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL = "xpath=//label[contains(text(),'%s')]//following-sibling::input";

	// public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//label[contains(text(),'%s')]//following-sibling::input";

}
