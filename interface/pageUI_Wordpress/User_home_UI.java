package pageUI_Wordpress;

public class User_home_UI {
	public static final String POST_TITLE_TEXT = "Xpath=//article//h2//a[text()='%s']";
	public static final String POST_CURRENT_DATE_TEXT_BY_POST_TITLE = "xpath=//article//a[text()='%s']/parent::h2//following-sibling::div//span[@class='posted-on']//a/time[text()='%s']";
	public static final String BODY_TEXT_BY_POST_TITLE = "xpath=//article//a[text()='%s']/ancestor::header/following-sibling::div/p[text()='%s']";
	public static final String OUTHER_TEXT_BY_POST_TITLE = "xpath=//article//a[text()='%s']/parent::h2//following-sibling::div//span[@class='author vcard']//a[text()='%s']";
	// public static final String POST_CURRENT_DATE_TEXT_BY_POST_TITLE =
	// "XPATH=//article//a[text()='%s']//parent::h2//following-sibling::div//a//time[text()='%s']";

}
