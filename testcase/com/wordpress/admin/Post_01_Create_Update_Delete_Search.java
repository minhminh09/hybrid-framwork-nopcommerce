package com.wordpress.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject_Wordpress_Admin.Admin_DashboardPO;
import PageObject_Wordpress_Admin.Admin_LoginPO;
import PageObject_Wordpress_Admin.Admin_PostAddNewPO;
import PageObject_Wordpress_Admin.Admin_PostSearchPO;
import commons.BaseTest;
import commons.PageGeneratorManager;

//@Listeners(org.uncommons.reportng.HTMLReporter.class)
public class Post_01_Create_Update_Delete_Search extends BaseTest {
	String adminUsername = "automationfc";
	String adminPassword = "automationfc";
	String searchPostUrl;
	int randomNumber = generateFakeNumber();
	String postTilevalue = "Live coding title" + randomNumber;
	String postBodyvalue = "Live coding body" + randomNumber;
	String authorName = "automationfc";

	@Parameters({ "browser", "urlAdmin" })
	@BeforeClass
	public void beforeClass(String browserName, String urlAdmin) {
		log.info("Preconditon - Step 01 : Open browser and admin url");
		driver = getBrowserDriver(browserName, urlAdmin);
		adminLoginPage = PageObject_Wordpress_Admin.PageGeneratorManager.w_getAdminLoginPage(driver);

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
		adminPostAddNewPage.enterToAddNewPostTitle(postTilevalue);

		log.info("Create_Post - Step 05 : Enter to body");
		adminPostAddNewPage.enterToAddBodyPostTitle(postBodyvalue);

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

		log.info("Search_Post - Step 03 : Click to 'Search Post' button");

		log.info("Search_Post - Step 04 : Verify Search table  contains' " + postTilevalue + "'");

		log.info("Search_Post - Step 05 : Verify Search table  contains' " + authorName + "'");

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
}
