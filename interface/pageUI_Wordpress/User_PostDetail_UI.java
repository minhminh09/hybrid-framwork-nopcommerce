package pageUI_Wordpress;

public class User_PostDetail_UI {
	public static final String POST_TITLE_TEXT = "Xpath=//article//h1[text()='%s']";
	public static final String POST_CURRENT_DATE_TEXT_BY_POST_TITLE = "XPATH=//article//h1[text()='%s']//following-sibling::div//a//time[text()='%s']";
	public static final String BODY_TEXT_BY_POST_TITLE = "xpath=//article//h1[text()='%s']/ancestor::header/following-sibling::div/p[text()='%s']";
	public static final String OUTHER_TEXT_BY_POST_TITLE = "xpath=//article//h1[text()='%s']//following-sibling::div//span[@class='author vcard']/a[text()='%s']";

}
