package SetupClass.StepDefinition;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import SetupClass.SetupClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Facebook_existing_user_sign_in_6 extends SetupClass {

	WebDriverWait wait = new WebDriverWait(driver,30);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@Given("^user is already on Home Page of Geeks Website vi$")
	public void user_is_already_on_Home_Page_of_Geeks_Website_vi() throws Throwable {
		Thread.sleep(1000);
		driver.get(AppURL);
		driver.manage().deleteAllCookies();
		Thread.sleep(4000);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		log.info("It's opening the website URL");
		Thread.sleep(1000);
	    
	}

	@Then("^user navigates to fb login page vi$")
	public void user_navigates_to_login_page_vi() throws Throwable {
		WebElement fb_login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#facebook-signin-btn > i")));
		 Thread.sleep(3000);
		 fb_login_btn.click();
		 Thread.sleep(3000);
	}

	@Then("^user login to website vi$")
	public void user_login_to_website_vi() throws Throwable {
		
      driver.manage().window().maximize();
		// String handle = " ";
		String currentWindow = driver.getWindowHandle();
		String popupWindowHandle = null;

		  
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(currentWindow)) {

				popupWindowHandle = handle;
				driver.switchTo().window(popupWindowHandle);
				driver.manage().window().maximize();

				Thread.sleep(5000);

				WebElement fb_email = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
				// Thread.sleep(3000);
				fb_email.clear();
				fb_email.sendKeys("slidetech.qa@gmail.com");
				Thread.sleep(3000);
				WebElement fb_pass = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='pass']")));
				// Thread.sleep(3000);
				fb_pass.clear();
				fb_pass.sendKeys("himanshi@123");

				Thread.sleep(6000);
				WebElement fb_login_btn2 = wait.until(
						ExpectedConditions.elementToBeClickable(By.xpath("*//input[contains(@value,'Log In')]")));
				fb_login_btn2.click();
				Thread.sleep(3000);
				// to verify the continue button 
				// button[normalize-space()='Yes, Continue']

			}
		}
		driver.switchTo().window(currentWindow);
	}

	@Then("^user is redirected my dashboard page vi$")
	public void user_is_redirected_my_dashboard_page_vi() throws Throwable {
		log.info("Hey, I am on Pricing");
	}

	@Then("^user download a paid product vi$")
	public void user_download_a_paid_product_vi() throws Throwable {
		Thread.sleep(3000);
		driver.get("https://www.slidegeeks.com/business/product/company-vulnerability-administration-ppt-powerpoint-presentation-complete-deck-with-slides");
		Thread.sleep(3000);
		 
		 WebElement download_btn = driver.findElement(By.xpath("//a[@class='btn-download pg-button pg-addtocart pg-green-background-btn vwo_subscribe_click']"));
		 Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();",download_btn);
		Thread.sleep(2000);
		 download_btn.click();
		 Thread.sleep(3000);
		 
	    	}

	@Then("^user signout of website vi$")
	public void user_signout_of_website_vi() throws Throwable {

		// Log out
				/* WebElement login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.afterBody.signin-page-wrapper.main-wrapper > header > div > div > nav > div > div.rgth_sechedr > div.navigation_wrapper > div.social_right > div > div.contact.login-option > ul > li:nth-child(2) > a")));
				 Thread.sleep(3000);
				 login_btn.click();
				 Thread.sleep(3000);
				 log.info("Hey, I am on Home page Again after Sign out");*/
				 Thread.sleep(1000);
	
		try {
			WebElement Signout = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("LOGOUT")));
			Thread.sleep(3000);
			Signout.click();
		} catch (NoSuchElementException e) {

		}
	}
}
