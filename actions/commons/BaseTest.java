package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private WebDriver driver;

	protected WebDriver getBrowserDriver(String browserName) {
		System.out.println("Run on" + browserName);
		if (browserName.equals("firefox")) {
			driver = WebDriverManager.firefoxdriver().create();
			driver = new FirefoxDriver();
		} else if (browserName.equals("h_firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("windown-size=1920*1080");
			driver = new FirefoxDriver(options);
		} else if (browserName.equals("chrome")) {
			driver = WebDriverManager.chromedriver().create();
			driver = new ChromeDriver();
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
			options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
			driver = ChromeDriver(options);
		} else {
			throw new RuntimeException("Browser name invalid");
		}

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		return driver;
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	private WebDriver ChromeDriver(ChromeOptions options) {
		// TODO Auto-generated method stub
		return null;
	}

}
