package commons;

import java.io.IOException;
import java.lang.StackWalker.Option;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest<BrowserList> {

	private WebDriver driver;
	protected final Log log;

	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}

	protected void closeBrowserDriver() {
		String cmd = null;
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			String browserDriverName = null;

			if (driverInstanceName.contains("chrome")) {
				browserDriverName = "chromedriver";
			} else if (driverInstanceName.contains("internetexplorer")) {
				browserDriverName = "IEDriverServer";
			} else if (driverInstanceName.contains("firefox")) {
				browserDriverName = "geckodriver";
			} else if (driverInstanceName.contains("edge")) {
				browserDriverName = "msedgedriver";
			} else if (driverInstanceName.contains("opera")) {
				browserDriverName = "operadriver";
			} else {
				browserDriverName = "safaridriver";
			}

			if (osName.contains("window")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
			} else {
				cmd = "pkill " + browserDriverName;
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	protected WebDriver getBrowserDriver(String browserName) {
		// BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		System.out.println("Run on" + browserName);
		if (browserName.equals("firefox")) {
			driver = WebDriverManager.firefoxdriver().create();

			// driver = new FirefoxDriver();
		} else if (browserName.equals("h_firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("windown-size=1920*1080");
			driver = new FirefoxDriver(options);
		} else if (browserName.equals("chrome")) {
			driver = WebDriverManager.chromedriver().create();
			// set browser language= Vietnamess
			ChromeOptions options = new ChromeOptions();
			//
			options.addArguments("--disable-notifications");
			options.addArguments("--lang=vi");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("h_firefox")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("windown-size=1920*1080");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("edge")) {
			driver = WebDriverManager.edgedriver().create();
			driver = new EdgeDriver();
		} else if (browserName.equals("opera")) {
			driver = WebDriverManager.operadriver().create();
			driver = new OperaDriver();
		} else if (browserName.equals("coccoc")) {
			// cốc cốc driver trừ đi 5-6 version thì ra chromedriver
			WebDriverManager.chromedriver().driverVersion("114.0.5735.16").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver = ChromeDriver(options);
		} else if (browserName.equals("brave")) {
			// brave browser version nào dùng chromedriver version đó
			WebDriverManager.chromedriver().driverVersion("114.0.5735.90").setup();
			ChromeOptions options = new ChromeOptions();

			if (GlobalConstants.OS_NAME.startsWith("Windown")) {
				options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			} else {
				options.setBinary("....");
			}

			driver = ChromeDriver(options);
		} else {
			throw new RuntimeException("Browser name invalid");
		}
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get(GlobalConstants.URL__PAGE_USER);
		return driver;
	}

	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		System.out.println("Run on" + browserName);
		if (browserName.equals("firefox")) {
			driver = WebDriverManager.firefoxdriver().create();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-geolocation");

			options.addPreference("intl.accept_langueges", "vi-vn, vi, en-us, en");

			driver = new FirefoxDriver(options);
		} else if (browserName.equals("h_firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("windown-size=1920*1080");
			driver = new FirefoxDriver(options);
		} else if (browserName.equals("chrome")) {
			driver = WebDriverManager.chromedriver().create();
			// set browser language= Vietnamess
			ChromeOptions options = new ChromeOptions();
			//
			// options.addArguments("--disable-notifications");
			// options.addArguments("--disable-geolocation");
			// options.setExperimentalOption("useAutomationExtention", false);
			// options.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automation"));
			// options.addArguments("--lang=vi");
			driver = new ChromeDriver(options);

		} else if (browserName.equals("h_firefox")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("windown-size=1920*1080");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("edge")) {
			driver = WebDriverManager.edgedriver().create();
			driver = new EdgeDriver();
		} else if (browserName.equals("opera")) {
			driver = WebDriverManager.operadriver().create();
			driver = new OperaDriver();
		} else if (browserName.equals("coccoc")) {
			// cốc cốc driver trừ đi 5-6 version thì ra chromedriver
			WebDriverManager.chromedriver().driverVersion("114.0.5735.16").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			driver = ChromeDriver(options);
		} else if (browserName.equals("brave")) {
			// brave browser version nào dùng chromedriver version đó
			WebDriverManager.chromedriver().driverVersion("114.0.5735.90").setup();
			ChromeOptions options = new ChromeOptions();

			if (GlobalConstants.OS_NAME.startsWith("Windown")) {
				options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			} else {
				options.setBinary("....");
			}

			driver = ChromeDriver(options);
		} else {
			throw new RuntimeException("Browser name invalid");
		}

		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get(appUrl);
		return driver;
	}

	private String getEnvironmentUrl(String envitonmentName) {
		String envUrl = null;
		switch (envitonmentName) {
		case "DEV":
			envUrl = GlobalConstants.DB_DEV_URL;
			break;
		case "TEST":
			envUrl = GlobalConstants.URL_TEST_PAGE;
			break;

		}
		return envUrl;
	}

	public WebDriver getDriverInstance() {
		return this.driver;
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	private WebDriver ChromeDriver(ChromeOptions options) {
		// TODO Auto-generated method stub
		return null;
	}

	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected String getCurrentDate() {
		DateTime nowUTC = new DateTime();
		int day = nowUTC.getDayOfMonth();
		if (day < 10) {
			String dayvalue = "0" + day;
			return dayvalue;
		}
		return String.valueOf(day);
	}

	protected String getCurrentMonth() {
		DateTime now = new DateTime();
		int month = now.getMonthOfYear();
		if (month < 10) {
			String monthvalue = "0" + month;
			return monthvalue;
		}
		return String.valueOf(month);
	}

	protected String getCurrentYear() {
		DateTime now = new DateTime();
		return String.valueOf(now.getYear());
	}

	protected String getCurrentDay() {
		return getCurrentDate() + "/" + getCurrentMonth() + "/" + getCurrentYear();
	}

}
