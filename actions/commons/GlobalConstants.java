package commons;

import java.io.File;

public class GlobalConstants {
	public static final String URL_PAGE_ADMIN = "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F";
	public static final String URL__PAGE_USER = "https://demo.nopcommerce.com/";
	public static final String URL_DEV_PAGE = "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F";
	public static final String URL_TEST_PAGE = "https://demo.nopcommerce.com/";

	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLog";
	public static final String DRAP_DROP_HTML5 = PROJECT_PATH + File.separator + "drapDropHTML5";
	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoIT";
	public static final String REPORTING_SCREENSHOT = PROJECT_PATH + File.separator + "ReportNGScreenShots" + File.separator;

	public static final String DB_DEV_URL = "32.18.252.185:9860";
	public static final String DB_DEV_USER = "autotesting";
	public static final String DB_DEV_PASS = "123456";
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	public static final long RETRY_TEST_FAIL = 3;
}
