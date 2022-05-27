package SetupClass.StepDefinition;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.Arrays;
import java.util.*;
import org.junit.Assert;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.NoSuchElementException;

import SetupClass.SetupClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CO_Checkout extends SetupClass {
	
	WebDriverWait wait = new WebDriverWait(driver,50);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	
	@Given("^user is already on Website Home Page CO$")
	public void user_is_already_on_Website_Home_Page_CO() throws Throwable {
		Thread.sleep(1000);
		driver.get(AppURL);
		driver.manage().deleteAllCookies();
		Thread.sleep(5000);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		log.info("It's opening the website URL");
		Thread.sleep(1000);
		/*try {
			boolean logout =wait.until(ExpectedConditions.elementToBeClickable(By.linkText("LOGOUT"))).isDisplayed();
			
			if (logout == true) {
				
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText("LOGOUT"))).click();
				
				Thread.sleep(2000);
				driver.navigate().refresh();
			 Thread.sleep(2000);
			}
			
			else 
			{System.out.println("Element not dispalyed");}
		} catch (NoSuchElementException Ext) {

		}*/
		String pp_page_title = driver.getTitle();
			System.out.println("Title of the Page is --> " + pp_page_title);
		
		try {
			WebElement login_signup_btn = wait
					.until(ExpectedConditions.elementToBeClickable(By.linkText("SIGNUP FOR FREE")));
			Thread.sleep(3000);
			login_signup_btn.click();
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {

		}
		 
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
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();

		System.out.println(generatedString);

		String signup_email = generatedString;
		String full_email = "selenium.testing." + generatedString + "@gmail.com";
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

    @Then("^user is redirected to pricing page and choose a plan to pay (\\d+)CO$")
	public void user_is_redirected_to_pricing_page_and_choose_a_plan_to_pay_CO(int arg1) throws Throwable {
		// choose a plan
		try {
			WebElement Subscribe_btn = driver.findElement(By.xpath(
					"//div[@id='Individual']//form[@name='hikashop_product_form_205548_hikashop_category_information_menu_117']//span[contains(text(),'Join now')]"));
			js.executeScript("arguments[0].scrollIntoView();", Subscribe_btn);
			Thread.sleep(2000);
			Subscribe_btn.click();
			Thread.sleep(6000);
		} catch (NoSuchElementException e) {

		}

	}

	/*@Then("^user is redirected to checkout page (\\d+)CO$")
	public void user_is_redirected_to_checkout_page_CO(int arg1) throws Throwable {
		Thread.sleep(6000);
    WebElement Continue =  driver.findElement(By.xpath("//*[@id='pg-checkout-shipping-info']/div[1]/div/div/div/div[2]/button"));
	js.executeScript("arguments[0].scrollIntoView();",Continue);
		Thread.sleep(1000);
		Continue.click();
	}*/

	@Then("^user proceed to pay with (\\d+)CO (\\d+)CO$")
	public void user_proceed_to_pay_with_CO_CO(int arg1, int arg2) throws InterruptedException {
	    try {
			Thread.sleep(1400);
			// select 2co option
			String radio_button_url = driver.getCurrentUrl();
			System.out.println("radio_button_url = " + radio_button_url);
			WebElement co_btn = driver.findElement(By.xpath(
					"//label[@for='payment_radio_1_2__stripe_2']"));
			Thread.sleep(2000);
			co_btn.click();
			Thread.sleep(5000);
		} catch (NoSuchElementException popup) {
		}

		// place order button
		try {

			WebElement place_order_btn = driver.findElement(By.xpath(
					"//button[@id='hikabtn_checkout_next']"));
			Thread.sleep(2000);
			js.executeScript("arguments[0].scrollIntoView();", place_order_btn);
			// js.executeScript("arguments[0].click();", place_order_btn);
			Thread.sleep(2000);
			place_order_btn.click();

		} catch (NoSuchElementException popup) {
		}
		
		
	}

	@Then("^CO page appears and user navigates back to my account (\\d+)CO$")
	public void CO_page_appears_and_user_navigates_back_to_my_account_CO(int arg1) throws Throwable {
	   Thread.sleep(6000);
		String stripe_page_title = driver.getTitle();
		Thread.sleep(3000);
		System.out.println("Title of the Page is --> " + stripe_page_title);

		String page_title = "SlideTeam Geeks Inc";

		if (page_title.equalsIgnoreCase(stripe_page_title)) {
			System.out.println(" user is on the Stripe page");

		} else {
			System.out.println("user is on the wrong page");

		}

		Thread.sleep(3000);
		WebElement Stripe_email = driver.findElement(By.cssSelector("#email"));
		Thread.sleep(2000);
		Stripe_email.sendKeys("slidetech.qa@gmail.com");
		Thread.sleep(2000);
		WebElement Stripe_back = driver.findElement(By.cssSelector(
				"#root > div > div > div.App-Overview > header > div > div > a > div > div > div.Header-backArrowContainer > svg"));
		Thread.sleep(2000);
		Stripe_back.click();
		Thread.sleep(2000);
		try {
			if (wait.until(ExpectedConditions.alertIsPresent()) != null)
				driver.switchTo().alert().accept();

		} catch (TimeoutException eTO) {

		}
		
	}

	@Then("^user signout the account (\\d+)CO$")
	public void user_signout_the_account_CO(int arg1) throws Throwable {
		Thread.sleep(3000);
	 WebElement Account = driver.findElement(
				By.xpath("/html/body/div[1]/header/div/div/nav/div/div[2]/div[2]/div[2]/div/div[2]/ul/li[1]/a"));
		Thread.sleep(3000);
		Account.click();
		Thread.sleep(3000);
		WebElement Delete_Account = driver
				.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/div/div[2]/div/ul/li[6]/a"));
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();", Delete_Account);
		Thread.sleep(3000);
		Delete_Account.click();
		Thread.sleep(3000);
		WebElement Delete_Account_reason = driver.findElement(By.cssSelector("#only-free-download-product"));
		Thread.sleep(3000);
		Delete_Account_reason.click();
		Thread.sleep(3000);
		WebElement Delete_Profile = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div/div[3]/button[1]"));
		Thread.sleep(3000);
		Delete_Profile.click();
		Thread.sleep(3000);
		WebElement No_Delete = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div/div[3]/button[2]"));
		Thread.sleep(3000);
		No_Delete.click();
		Thread.sleep(4000);
		
		//verify wether the account is deleted or not?

		String verifyDeleteAccountMessage = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='alert-message login-sucesmsg']")))
				.getText();
		System.out.println("verifyText1 = " + verifyDeleteAccountMessage);

		Assert.assertTrue("Your account is not deleted",
				verifyDeleteAccountMessage.contentEquals("Your Account has been deleted successfully."));
		System.out.println("Account delete successfully");
	
}
}
