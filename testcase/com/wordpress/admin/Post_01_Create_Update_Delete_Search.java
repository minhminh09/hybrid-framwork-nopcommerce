package com.wordpress.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject_Wordpress.Admin_DashboardPO;
import PageObject_Wordpress.Admin_LoginPO;
import PageObject_Wordpress.Admin_PostAddNewPO;
import PageObject_Wordpress.Admin_PostSearchPO;
import PageObject_Wordpress.User_HomePO;
import PageObject_Wordpress.User_PostDetailPO;
import commons.BaseTest;
import commons.PageGeneratorManager;

//@Listeners(org.uncommons.reportng.HTMLReporter.class)
public class Post_01_Create_Update_Delete_Search extends BaseTest {
	String adminUsername = "automationfc";
	String adminPassword = "automationfc";
	String searchPostUrl;
	int randomNumber = generateFakeNumber();
	String postTitle = "Live coding title" + randomNumber;
	String postBody = "Live coding body" + randomNumber;
	String authorName = "automationfc";
	String adminUrl, endUserUrl;
	String currentDay = getCurrentDay();

	@Parameters({ "browser", "urlAdmin", "urlUser" })
	@BeforeClass
	public void beforeClass(String browserName, String urlAdmin, String endUserUrl) {
		log.info("Preconditon - Step 01 : Open browser and Admin site");
		this.adminUrl = urlAdmin;
		this.endUserUrl = endUserUrl;
		driver = getBrowserDriver(browserName, this.adminUrl);
		adminLoginPage = PageObject_Wordpress.PageGeneratorManager.w_getAdminLoginPage(driver);

		log.info("Preconditon - Step 02 : Enter to username textbox with value: " + adminUsername);
		adminLoginPage.enterToUsernameTextbox(adminUsername);

		log.info("Preconditon - Step 03 : Enter to password textbox with value: " + adminPassword);
		adminLoginPage.enterToPassWordTextbox(adminPassword);

		log.info("Preconditon - Step 04 : Click to Login button");
		adminDashboardPage = adminLoginPage.clicktoButtonLogin();

	}

	@Test
	public void Post_01_Create_New_Post() {
		log.info("Create_Post - Step 01 : Click to Post menu link");
		adminPostSearchPage = adminDashboardPage.clicktoPostMenuLink();

		log.info("Create_Post - Step 02 : Get 'Search post' page Url");
		searchPostUrl = adminPostSearchPage.getPageURL(driver);

		log.info("Create_Post - Step 03 : Click Add New Post button");
		adminPostAddNewPage = adminPostSearchPage.clicktoAddNewPostButton();

		log.info("Create_Post - Step 04 : Enter to post title");
		adminPostAddNewPage.enterToAddNewPostTitle(postTitle);

		log.info("Create_Post - Step 05 : Enter to body");
		adminPostAddNewPage.enterToAddBodyPostTitle(postBody);

		log.info("Create_Post - Step 06 : Click to 'Publish' button");
		adminPostAddNewPage.clickToPublistButton();

		log.info("Create_Post - Step 07 : Click to 'PRE_Publish' button");
		adminPostAddNewPage.clickToPRE_PublistButton();

		log.info("Create_Post - Step 08 : Verify 'Post Published' message is display ");
		verifyTrue(adminPostAddNewPage.isPostPublishMessageIsDisplayed("Post published."));
	}

	@Test
	public void Post_02_Search_Post() {
		log.info("Search_Post - Step 01 : Open 'Search Post' page");
		adminPostSearchPage = adminPostAddNewPage.searchPostPageUrl(searchPostUrl);

		log.info("Search_Post - Step 02 : Enter to search textbox");
		adminPostSearchPage.enterToSearchTextbox(postTitle);

		log.info("Search_Post - Step 03 : Click to 'Search Post' button");
		adminPostSearchPage.clickToSearchPostButton();

		log.info("Search_Post - Step 04 : Verify Search table  contains' " + postTitle + "'");
		adminPostSearchPage.isPostSearchTableisDisplay("title", postTitle);

		log.info("Search_Post - Step 05 : Verify Search table  contains' " + authorName + "'");
		adminPostSearchPage.isPostSearchTableisDisplay("author", authorName);

		log.info("Search_Post - Step 06 : Open End User site");
		userHomePO = adminPostSearchPage.openEndUserSite(driver, this.endUserUrl);

		log.info("Search_Post - Step 07 : Verify Post infor display at Home page");
		verifyTrue(userHomePO.isPostInforDisplayed_POST_TITLE(postTitle));
		verifyTrue(userHomePO.isPostInforDisplayed_POST_BODY(postTitle, postBody));
		verifyTrue(userHomePO.isPostInforDisplayed_POST_AUTHOR(postTitle, authorName));
		verifyTrue(userHomePO.isPostInforDisplayed_POST_CURRENT_DAY(postTitle, currentDay));

		log.info("Search_Post - Step 08 : Click to post title");
		userPostDetailPO = userHomePO.clickToPostTitle(postTitle);

		log.info("Search_Post - Step 09 : Verify Post infor display at Post detail page");
		verifyTrue(userPostDetailPO.isPostInforDisplayed_POST_TITLE(postTitle));
		verifyTrue(userPostDetailPO.isPostInforDisplayed_POST_BODY(postTitle, postBody));
		verifyTrue(userPostDetailPO.isPostInforDisplayed_POST_AUTHOR(postTitle, authorName));
		verifyTrue(userPostDetailPO.iisPostInforDisplayed_POST_CURRENT_DAY(postTitle, currentDay));
	}

	@Test
	public void Post_03_View_Post() {

	}

	@Test
	public void Post_04_Edit_Post() {

	}

	@Test
	public void Post_05_Delete_Post() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();

	}

	private WebDriver driver;
	Admin_LoginPO adminLoginPage;
	Admin_DashboardPO adminDashboardPage;
	Admin_PostSearchPO adminPostSearchPage;
	Admin_PostAddNewPO adminPostAddNewPage;
	User_HomePO userHomePO;
	User_PostDetailPO userPostDetailPO;
}
