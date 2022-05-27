package SetupClass.StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import SetupClass.SetupClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Google_new_user_sign_up_8 extends SetupClass {

	WebDriverWait wait = new WebDriverWait(driver,30);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	@Given("^user is already on Home Page of Geeks Website viii$")
	public void user_is_already_on_Home_Page_of_Geeks_Website_viii() throws Throwable {
		
		driver.get(AppURL);
		driver.manage().deleteAllCookies();
		Thread.sleep(4000);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		log.info("It's opening the website URL");
		Thread.sleep(1000);
	    
	}

	@Then("^user navigates to google login page viii$")
	public void user_navigates_to_google_login_page_viii() throws Throwable {
		try {
			WebElement fb_login_btn = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='icon fa fa-google']")));
			Thread.sleep(3000);
			fb_login_btn.click();
			Thread.sleep(3000);
		} catch (NoSuchElementException e1) {
			
		}
	}

	@Then("^user login to website viii$")
	public void user_login_to_website_viii() throws Throwable {
		
                driver.manage().window().maximize();
		
		 // Store the CurrentWindow for future reference
		// String handle = " ";
		String currentWindow = driver.getWindowHandle();
		String popupWindowHandle = null;

		// Switch To Popup Window

		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(currentWindow)) {

				popupWindowHandle = handle;
				driver.switchTo().window(popupWindowHandle);
				driver.manage().window().maximize();

				Thread.sleep(5000);

				WebElement g_email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
						"/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[1]/div/div[1]/input")));
				Thread.sleep(3000);
				g_email.sendKeys("slidetech.qa@gmail.com");
				Thread.sleep(3000);

				WebElement g_login_btn1 = wait.until(ExpectedConditions
						.elementToBeClickable(By.cssSelector("#identifierNext > div > button > span")));
				Thread.sleep(3000);
				g_login_btn1.click();

				Thread.sleep(3000);

				WebElement g_pass = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
						"/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input")));
				Thread.sleep(3000);
				g_pass.sendKeys("Himanshi@123");

				Thread.sleep(3000);
				WebElement g_login_btn2 = wait.until(
						ExpectedConditions.elementToBeClickable(By.cssSelector("#passwordNext > div > button > span")));
				Thread.sleep(3000);
				g_login_btn2.click();

				Thread.sleep(3000);
			}
		}
		driver.switchTo().window(currentWindow);
		Thread.sleep(6000);
	}

	@Then("^user is redirected my dashboard page viii$")
	public void user_is_redirected_my_dashboard_page_viii() throws Throwable {
		log.info("Hey, I am on Pricing");
	}

	@Then("^user download a free product viii$")
	public void user_download_a_free_product_viii() throws Throwable {
		
		driver.get("https://www.slidegeeks.com/free-downloads");
		Thread.sleep(4000);

		WebElement Download = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("/html/body/div[1]/div[3]/div/section[2]/div/div/div[1]/div/div[2]/div[1]/div/div/p/a/span")));

		// WebElement Download = (WebElement)js.executeScript("('a.btn-download')", "");
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();", Download);
		Download.click();
		Thread.sleep(3000);
		WebElement download_btn = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Download this Presentation")));
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();", download_btn);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", download_btn);
		Thread.sleep(3000);
		//download_btn.click();
		Thread.sleep(3000);
		 
	    	}

	@Then("^user signout of website viii$")
	public void user_signout_of_website_viii() throws Throwable {

		// Log out
				/* WebElement login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.afterBody.signin-page-wrapper.main-wrapper > header > div > div > nav > div > div.rgth_sechedr > div.navigation_wrapper > div.social_right > div > div.contact.login-option > ul > li:nth-child(2) > a")));
				 Thread.sleep(3000);
				 login_btn.click();
				 Thread.sleep(3000);
				 log.info("Hey, I am on Home page Again after Sign out");
				 Thread.sleep(1000);*/
		try {
			WebElement Signout = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("LOGOUT")));
			Thread.sleep(3000);
			Signout.click();
			System.out.println("Logout click successfully");

		} catch (NoSuchElementException e) {

		}
	}
}
