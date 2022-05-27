package SetupClass.StepDefinition;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import java.lang.*;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Keys;

import SetupClass.SetupClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Paypal_Checkout extends SetupClass {
	
	WebDriverWait wait = new WebDriverWait(driver,50);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	
	@Given("^user is already on Website Home Page$")
	public void user_is_already_on_Website_Home_Page() throws Throwable {
		driver.get(AppURL);
		 Thread.sleep(1000);
		driver.manage().deleteAllCookies();
		 Thread.sleep(4000);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		log.info("It's opening the website URL");
		Thread.sleep(1000);
		
		try {
			WebElement login_signup_btn = wait
					.until(ExpectedConditions.elementToBeClickable(By.linkText("SIGNUP FOR FREE")));
			Thread.sleep(3000);
			login_signup_btn.click();
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {

		}
	    
		//Thread.sleep(3000);
		//driver.get("https://www.slidegeeks.com/register");
		//Thread.sleep(3000);
		WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#register_name")));
		 Thread.sleep(3000);
		 name.sendKeys("Automated Program");
		 Thread.sleep(3000);
	   
	
		// Generate Random Email Address
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	 
	    System.out.println(generatedString);
	    
	    String signup_email=generatedString;
	    String full_email="selenium.testing."+generatedString+"@gmail.com";
	    System.out.println(full_email);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		Thread.sleep(2000);
		
		WebElement new_email = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#register_email")));
		 Thread.sleep(3000);
		 new_email.sendKeys(full_email);
		 Thread.sleep(3000);
		
	
		WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#register_password")));
		 Thread.sleep(3000);
		password.sendKeys("Geeks@123");
		 Thread.sleep(3000);
		 
		WebElement confirm_passwoed = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#register_password2")));
		 Thread.sleep(3000);
		confirm_passwoed.sendKeys("Geeks@123");
		 Thread.sleep(3000);
	    
	         WebElement captcha = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#captchtext")));
		 Thread.sleep(3000);
		 captcha.sendKeys("Y3Tt6bfwI");
		 Thread.sleep(3000);
	    

		 WebElement register_btn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".pg-register-button-new")));
		 Thread.sleep(3000);
		register_btn.click();
		 Thread.sleep(5000);
	}
	
  
    @Then("^user is redirected to pricing page and choose the plan to pay$")
	public void user_is_redirected_to_pricing_page_and_choose_the_plan_to_pay() throws Throwable {
		try {
			WebElement Business_Team = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//button[@onclick=\"if (!window.__cfRLUnblockHandlers) return false; pricingbutton(event, 'Business')\"]")));
			Thread.sleep(2000);
			js.executeScript("arguments[0].scrollIntoView();", Business_Team);
			js.executeScript("arguments[0].click();", Business_Team);
			Thread.sleep(2000);

			WebElement Subscribe_btn = driver.findElement(By.xpath(
					"//div[@id='Individual']//form[@name='hikashop_product_form_99148_hikashop_category_information_menu_117']//span[contains(text(),'Join now')]"));
			js.executeScript("arguments[0].scrollIntoView();", Subscribe_btn);
			Thread.sleep(3000);
			js.executeScript("arguments[0].click();", Subscribe_btn);
		} catch (NoSuchElementException e1) {
			
		}

	}

	@Then("^user is redirected checkout page$")
	public void user_is_redirected_checkout_page() throws Throwable {
		Thread.sleep(2000);
    //WebElement Continue =  driver.findElement(By.xpath("//*[@id='pg-checkout-shipping-info']/div[1]/div/div/div/div[2]/button"));
	//js.executeScript("arguments[0].scrollIntoView();",Continue);
		//Thread.sleep(1000);
		//Continue.click();
	}

	@Then("^user proceed to pay with paypal pp$")
	public void user_proceed_to_pay_with_paypal_pp() throws Throwable {
	
		Thread.sleep(1400);
		
		    try
		{
			WebElement cp_btn  = driver.findElement(By.xpath("//label[@for='payment_radio_1_2__paypal_1']"));
			Thread.sleep(2000);
		    cp_btn.click();
		    Thread.sleep(3000);
		}
		catch (NoSuchElementException popup) {
			// TODO: handle exception
		}
		
		Thread.sleep(1000);
		   try {
			
		 WebElement place_order_btn  =  driver.findElement(By.xpath("//button[@id='hikabtn_checkout_next']> div > div.checkout-inner-wrapper > div.checkout-box-wrapper.checkout-order > div > div > table > tbody > tr:nth-child(4) > td:nth-child(1) > button.btn.primary-btn.pg-button.pg-checkout-continue"));
			Thread.sleep(2000);
			js.executeScript("arguments[0].scrollIntoView();",place_order_btn);	
			//js.executeScript("arguments[0].click();", place_order_btn);
			Thread.sleep(2000);
		    place_order_btn.click();
			Thread.sleep(5000);
		} catch (NoSuchElementException popup) {
		}
		
		
	}

	@Then("^paypal popup appears and user navigates back to my account pp$")
	public void paypal_popup_appears_and_user_navigates_back_to_my_account_pp() throws Throwable {
	         
		Thread.sleep(1000);
		/*try {

			WebElement place_order_btn = driver.findElement(By.cssSelector(
					"body > div.afterBody.checkout-wrapper.main-wrapper.no-left-menu > div.main_wrapper > div > div.checkout-inner-wrapper > div.checkout-box-wrapper.checkout-order > div > div > table > tbody > tr:nth-child(4) > td:nth-child(1) > button.btn.primary-btn.pg-button.pg-checkout-continue"));
			Thread.sleep(2000);
			js.executeScript("arguments[0].scrollIntoView();", place_order_btn);
			// js.executeScript("arguments[0].click();", place_order_btn);
			Thread.sleep(2000);
			place_order_btn.click();
			Thread.sleep(5000);
		} catch (NoSuchElementException popup) {
		}*/

		String pp_page_URL = driver.getCurrentUrl();
		System.out.println("URL of the Page is --> " + pp_page_URL);

		if (pp_page_URL.equals("https://www.paypal.com/cgi-bin/webscr")) {

			System.out.println("security captcha is visible");

		} else {

			String pp_page_title = driver.getTitle();
			System.out.println("Title of the Page is --> " + pp_page_title);

			Assert.assertTrue("title does not matched", driver.getTitle().contains("Log in to your PayPal account"));

			Thread.sleep(1000);

			WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
			email.sendKeys("nishadhiman0027@gmail.com");
			WebElement next = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='btnNext']")));
			next.click();

			Thread.sleep(1000);
		}
			 
	}


	@Then("^user Signout account PP$")
	public void user_Signout_account_PP() throws Throwable {
		Thread.sleep(3000);
	        driver.get("https://www.slidegeeks.com/component/pago/checkout");
		Thread.sleep(2000);
		
		
		 	try {
			WebElement Signout = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("LOGOUT")));
			Thread.sleep(3000);
			Signout.click();
			System.out.println("Logout click successfully");

		} catch (NoSuchElementException e) {

		}
	}


	
}
