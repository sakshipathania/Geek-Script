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

public class Email_Sign_In_Free_User_4 extends SetupClass {
	
	WebDriverWait wait = new WebDriverWait(driver,30);
        JavascriptExecutor js = (JavascriptExecutor) driver;
	@Given("^user is already on Home Page of Geeks Website iv$")
	public void user_is_already_on_Home_Page_of_Geeks_Website_iv() throws Throwable {
		driver.manage().deleteAllCookies();
		Thread.sleep(2000);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		log.info("It's opening the website URL");
		Thread.sleep(1000);
		
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

	@Then("^user navigates to login page iv$")
	public void user_navigates_to_login_page_iv() throws Throwable {
		try {
			WebElement login_signin_btn = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Login']")));
			Thread.sleep(2000);
			login_signin_btn.click();
			Thread.sleep(2000);
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^user login to website iv$")
	public void user_login_to_website_iv() throws Throwable {
		
		//driver.get("https://www.slidegeeks.com/account");
	    //   Thread.sleep(5000);
	       
	      try {
			WebElement old_paid_email = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='E-mail Address']")));
			old_paid_email.sendKeys("Slidegeekstesting1@gmail.com");
			Thread.sleep(3000);
			WebElement old_paid_pass = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Password']")));
			old_paid_pass.sendKeys("Qwerty");

			Thread.sleep(3000);
			WebElement old_paid_login_btn = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='Submit']")));
			old_paid_login_btn.click();
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^user is redirected to Pricing page iv$")
	public void user_is_redirected_to_Pricing_page_iv() throws Throwable {
		log.info("Hey, I am on Pricing Page");
		 Thread.sleep(3000);
	}

	
	
	@Then("^user signout of website iv$")
	public void user_signout_of_website_iv() throws Throwable {
		
		// Log out
		/*  WebElement login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.afterBody.signin-page-wrapper.main-wrapper > header > div > div > nav > div > div.rgth_sechedr > div.navigation_wrapper > div.social_right > div > div.contact.login-option > ul > li:nth-child(2) > a")));
		Thread.sleep(3000);
		 login_btn.click();
		 Thread.sleep(3000);
		 log.info("Hey, I am on Home page Again after Sign out");
		 Thread.sleep(1000);*/
		try {
			WebElement Signout = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("LOGOUT")));
			Thread.sleep(3000);
			Signout.click();
			System.out.println("Signout from the application");
		} catch (NoSuchElementException e) {

		}
	}




	
}
