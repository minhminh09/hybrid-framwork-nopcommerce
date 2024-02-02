package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject_NopCommerce_User.User_AddressesPageObject;
import PageObject_NopCommerce_User.User_CusstomerInforPageObject;
import PageObject_NopCommerce_User.User_HomePageObject;
import PageObject_NopCommerce_User.User_LoginPageObject;
import PageObject_NopCommerce_User.User_MyProductReviewsPageObject;
import PageObject_NopCommerce_User.User_RegisterPageObject;
import PageObject_NopCommerce_User.User_RewardPointsPageObject;
import commons.BaseTest;
import commons.PageGeneratorManager;
import utilites.DataHelper;

@Listeners(org.uncommons.reportng.HTMLReporter.class)
public class Level_19_Faker_Data extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		dataFaker = DataHelper.getDataHelper();

		firtName = dataFaker.getFirstName();
		lastName = dataFaker.getLastName();
		emailAddress = dataFaker.getEmail();
		password = dataFaker.getPassWord();
		homePage = new User_HomePageObject(driver);
		day = "10";
		month = "March";
		year = "2000";
	}

	@Test
	public void TC_01_Register() {
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();
		// radio button
		registerPage.clickToRadioButtonByLabel(driver, "Male");

		log.info("Register - Step 02: Enter to firtname textbox with value is ' " + firtName + "' ");
		registerPage.inputToTextboxById(driver, "FirstName", firtName);

		log.info("Register - Step 03: Enter to lastName textbox with value is ' " + lastName + "' ");
		registerPage.inputToTextboxById(driver, "LastName", lastName);

		// dropdown select
		registerPage.selectToDropdownName(driver, "DateOfBirthDay", day);
		registerPage.selectToDropdownName(driver, "DateOfBirthMonth", month);
		registerPage.selectToDropdownName(driver, "DateOfBirthYear", year);

		log.info("Register - Step 04: Enter to emailAddress textbox with value is ' " + emailAddress + "' ");
		registerPage.inputToTextboxById(driver, "Email", emailAddress);

		log.info("Register - Step 05: Enter to password textbox with value is ' " + password + "' ");
		registerPage.inputToTextboxById(driver, "Password", password);

		log.info("Register - Step 06: Enter to confirm password textbox with value is ' " + password + "' ");
		registerPage.inputToTextboxById(driver, "ConfirmPassword", password);

		// checkbox
		registerPage.clickToCheckboxByLabel(driver, "Newsletter");

		log.info("Register - Step 07: Click to register button");
		// registerPage.clickToRegisterButton();
		registerPage.clickToButtonText(driver, "Register");

		log.info("Register - Step 08: Verify message Sussesfull isDisplay");
		Assert.assertEquals(registerPage.getSussesfullMessage(), "Your registration completed");

		log.info("HomePagr - Step 09: Click to Logout Link");
		homePage = registerPage.clickToLogoutLink();

	}

	@Test
	public void TC_01_User_Login() {
		log.info("Login page - Step 01: Click to Login Link");
		loginPage = homePage.clickToLoginLink();

		log.info("Register - Step 02: Enter to firtname textbox with value is ' " + firtName + "' ");
		loginPage.inputToTextboxById(driver, "Email", emailAddress);

		log.info("Register - Step 03: Enter to password textbox with value is ' " + password + "' ");
		loginPage.inputToTextboxById(driver, "Password", password);

		log.info("Login page - Step 04: Click to Login Button");
		// homePage = loginPage.clickToLogInButton();
		registerPage.clickToButtonText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Login page - Step 05: Verify My Accout Link Display");
		Assert.assertTrue(homePage.isMyAccountLinkDisplay());

	}

	@Test
	public void TC_03_My_Account() {
		log.info("My Account - Step 01: Click to My Accout Link");
		customerInforPage = loginPage.clickToMyAccoutLink();

		log.info("MyAccount - Step 02: Verify My Account Page Display");
		Assert.assertTrue(customerInforPage.isMyaccountPageDisplay());

		log.info("My Account - Step 03: Verify 'Firt Name' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxByValueId(driver, "FirstName"), firtName);

		log.info("My Account - Step 04: Verify 'LastName' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxByValueId(driver, "LastName"), lastName);

		log.info("My Account - Step 05: Verify 'Email' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxByValueId(driver, "Email"), emailAddress);

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();

	}

	private WebDriver driver;
	private String emailAddress;
	private String firtName, lastName, password;
	private User_HomePageObject homePage;
	private User_RegisterPageObject registerPage;
	private User_LoginPageObject loginPage;
	private User_CusstomerInforPageObject customerInforPage;
	private User_AddressesPageObject addressesPage;
	private User_MyProductReviewsPageObject myProductReviewPage;
	private User_RewardPointsPageObject rewardPointsPage;
	private String day, month, year;
	private DataHelper dataFaker;

}
