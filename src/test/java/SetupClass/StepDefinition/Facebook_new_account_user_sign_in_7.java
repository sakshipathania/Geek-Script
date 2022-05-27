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

public class Facebook_new_account_user_sign_in_7 extends SetupClass {

	WebDriverWait wait = new WebDriverWait(driver,30);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	@Given("^user is already on Home Page of Geeks Website vii$")
	public void user_is_already_on_Home_Page_of_Geeks_Website_vii() throws Throwable {
		
		
		Thread.sleep(2000);
		driver.get("https://www.facebook.com/");
		driver.manage().deleteAllCookies();
		Thread.sleep(4000);
		driver.navigate().refresh();
		Thread.sleep(4000);
		
		driver.get(AppURL);

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		log.info("It's opening the website URL");
		//Thread.sleep(1000);
		/*try {
			WebElement Signout = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("LOGOUT")));
			if (Signout.isEnabled()) {
				Signout.click();
				Thread.sleep(2000);
				driver.navigate().refresh();
			 Thread.sleep(2000);
			}
		} catch (NoSuchElementException Ext) {

		}*/
		
			
	    
	}

	@Then("^user navigates to fb login page vii$")
	public void user_navigates_to_fb_login_page_vii() throws Throwable {
		WebElement fb_login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='facebook-signin-btn']")));
		 fb_login_btn.click();
		Thread.sleep(3000);
	}

	@Then("^user login to website vii$")
	public void user_login_to_website_vii() throws Throwable {
		
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

				WebElement fb_email = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));

				fb_email.clear();
				fb_email.sendKeys("ritapahwa08@gmail.com");

				WebElement fb_pass = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='pass']")));

				fb_pass.sendKeys("Qwerty@1");

				WebElement fb_login_btn1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("*//input[contains(@value,'Log In')]")));
				fb_login_btn1.click();
				Thread.sleep(3000);
				
			}
		}
		driver.switchTo().window(currentWindow);
		Thread.sleep(2000);
	}

	@Then("^user is redirected my dashboard page vii$")
	public void user_is_redirected_my_dashboard_page_vii() throws Throwable {
		Thread.sleep(6000);
		log.info("Hey, I am on Pricing");
		System.out.println("pricing url is " + driver.getCurrentUrl());
	}

	/*@Then("^user download a free product vii$")
	public void user_download_a_free_product_vii() throws Throwable {
		
		driver.get("https://www.slidegeeks.com/free-downloads");
		Thread.sleep(6000);
		
		WebElement Download= driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/section[2]/div/div/div[1]/div/div[2]/div[1]/div/div/p/a/span"));
		
		//WebElement Download = (WebElement)js.executeScript("('a.btn-download')", "");
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();",Download);
		Download.click();
		Thread.sleep(3000);
		 WebElement download_btn = driver.findElement(By.xpath("//a[@class='btn-download pg-button pg-addtocart pg-green-background-btn vwo_subscribe_click']"));
		 Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();",Download);
		Thread.sleep(3000);
		 download_btn.click();
		 Thread.sleep(3000);
		 
	    	}*/

	@Then("^user signout of website vii$")
	public void user_signout_of_website_vii() throws Throwable {

		// Log out
				/* WebElement login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.afterBody.signin-page-wrapper.main-wrapper > header > div > div > nav > div > div.rgth_sechedr > div.navigation_wrapper > div.social_right > div > div.contact.login-option > ul > li:nth-child(2) > a")));
				 Thread.sleep(3000);
				 login_btn.click();
				 Thread.sleep(3000);
				 log.info("Hey, I am on Home page Again after Sign out");*/
				// Thread.sleep(1000);
		//WebElement Signout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("*//a[contains(@href,'logout')]")));
		//WebElement Signout = driver.findElement(By.xpath("//a[@href ='/logout']"));
		
		try {
			WebElement Signout = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("LOGOUT")));
			Thread.sleep(3000);
			Signout.click();
			System.out.println("Logout click successfully");
		} catch (NoSuchElementException e) {

		}
		
	}
}
