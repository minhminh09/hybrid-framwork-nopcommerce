package com.nopcommerce.user;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commons.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(commons.MethodListener.class)
public class Topic_00_Assert extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.firefoxdriver().setup();

		driver = new FirefoxDriver();
		// driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}

	@Test
	public void TC_01_Url() {
		System.out.println("Assert 01");
		String loginPageUI = driver.getCurrentUrl();
		verifyEquals(loginPageUI, "https://www.facebook.com/");
		System.out.println("Assert 02");
		String loginPageTitle = driver.getTitle();
		verifyEquals(loginPageTitle, "Facebook - log in or sign up");

		System.out.println("Assert 03");
		verifyTrue(driver.findElement(By.cssSelector("img.fb_logo")).isDisplayed());

		System.out.println("Assert 04");
		verifyTrue(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}