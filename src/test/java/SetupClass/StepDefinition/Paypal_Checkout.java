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
		//driver.get("https://www.slidegeeks.com/");
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
		WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.name("jform[name1]")));
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
		
		WebElement new_email = wait.until(ExpectedConditions.elementToBeClickable(By.name("jform[email1]")));
		 Thread.sleep(3000);
		 new_email.sendKeys(full_email);
		 Thread.sleep(3000);
		
	
		WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#jform_password1")));
		 Thread.sleep(3000);
		password.sendKeys("Geeks@123");
		 Thread.sleep(3000);
		 
		 WebElement confirm_passwoed = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#jform_password2")));
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
		// choose a plan
		//driver.get("https://www.slidegeeks.com/subscriptions");
		Thread.sleep(3000);
		WebElement Business_Team = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div[1]/div/div/button[2]")));
				Thread.sleep(2000);
		Business_Team.click();
		Thread.sleep(4000);
		//js.executeScript("window.scrollBy(0,1000)");
		 WebElement Subscribe_btn  =  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div[2]/div/div[2]/div/div[3]/div[3]/span/form/span/button"));
		js.executeScript("arguments[0].scrollIntoView();",Subscribe_btn);
			Thread.sleep(2000);
		    Subscribe_btn.click();
			Thread.sleep(6000);

	}

	@Then("^user is redirected checkout page$")
	public void user_is_redirected_checkout_page() throws Throwable {
		Thread.sleep(6000);
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
			WebElement cp_btn  = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/input[1]"));
			Thread.sleep(2000);
		    cp_btn.click();
		    Thread.sleep(3000);
		}
		catch (NoSuchElementException popup) {
			// TODO: handle exception
		}
		
		Thread.sleep(1000);
		   try {
			
		 WebElement place_order_btn  =  driver.findElement(By.cssSelector("body > div.afterBody.checkout-wrapper.main-wrapper.no-left-menu > div.main_wrapper > div > div.checkout-inner-wrapper > div.checkout-box-wrapper.checkout-order > div > div > table > tbody > tr:nth-child(4) > td:nth-child(1) > button.btn.primary-btn.pg-button.pg-checkout-continue"));
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
	         
		// page title
		 String pp_page_title=driver.getTitle();
		 System.out.println("Title of the Page is --> "+pp_page_title);
		
		Assert.assertTrue("title does not matched",
						driver.getTitle().contains("Slideteam PTE LTD"));
		    

		Thread.sleep(1000);
		
	        //verify text message on paypal page 
		String verifyText1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//span[@class='Text Text-color--gray500 Text-fontSize--16 Text-fontWeight--500']")))
				.getText();
		System.out.println("verifyText1 = " + verifyText1);
		
		Assert.assertTrue("Your are not on paypal page",
				verifyText1.contentEquals("Subscribe to Annual 20-User License (plus 20 Custom Designed slides worth dollar 300)"));
		
		//verify price
		String verifyPrice = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='mr2 flex-item width-fixed']")))
				.getText();
		System.out.println("verifyText1 = " + verifyPrice);

		Assert.assertTrue("Your are not on paypal page", verifyPrice.contentEquals("$1,599.99"));
			 
	}


	@Then("^user Signout account PP$")
	public void user_Signout_account_PP() throws Throwable {
		Thread.sleep(3000);
	        driver.get("https://www.slidegeeks.com/component/pago/checkout");
		Thread.sleep(2000);
		
		
		 WebElement Signout = driver.findElement(By.xpath("//a[@href ='/logout']"));
		Thread.sleep(3000);
		Signout.click();
	}


	
}
