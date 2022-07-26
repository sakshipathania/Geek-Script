package SetupClass;

import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetupClass {

	public static WebDriver driver;
	public static String AppURL;
	public static Properties property = new Properties(System.getProperties());
	public static String browserName;
	public static Logger log;
	public static WebElement webelement;
	public static String local_chrome;
	public static String local_FFbrowser;
	public static WebDriverWait wait;
	public static JavascriptExecutor js;

	@BeforeClass
	public static void before_Class() throws Exception {
		log = Logger.getLogger(BeforeClass.class.getName());
		property.load(new FileReader("Config//config.properties"));
		AppURL = property.getProperty("App_url");
		local_chrome = property.getProperty("local_chrome");
		local_FFbrowser = property.getProperty("local_FFbrowser");
		// on source lab setup
		AppURL = property.getProperty("App_url");
		System.out.println("Bname=====" + AppURL);

		if ((local_chrome.equals("yes"))) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 30);
			js = (JavascriptExecutor) driver;
			Thread.sleep(1000);
		}
		// if (browser.equalsIgnoreCase("firefox"))

		// if (browser.equalsIgnoreCase("chrome"))
		else if ((local_FFbrowser.equals("yes"))) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 30);
			js = (JavascriptExecutor) driver;

			Thread.sleep(1000);
		} else {

			System.out.println("platform does not provide");
		}

	}

	public static void ClearBrowserCache() throws Throwable {

		driver.manage().deleteAllCookies();
		Thread.sleep(4000); // wait 7 seconds to clear cookies.
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

	public static void ClearfacebookCache() throws Throwable {
		Thread.sleep(2000);
		driver.get("https://www.facebook.com/");
		driver.manage().deleteAllCookies();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(2000);

	}

	public static void ClearGoggleCache() throws Throwable {
		Thread.sleep(2000);
		driver.get("https://mail.google.com/mail/u/0/#inbox");
		Thread.sleep(2000);
		driver.manage().deleteAllCookies();
		Thread.sleep(3000);
		driver.navigate().refresh();

	}

	@AfterClass
	public static void after_Class() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit(); // ->> don't want to close the browser for now
		Thread.sleep(2000);

	}

}
