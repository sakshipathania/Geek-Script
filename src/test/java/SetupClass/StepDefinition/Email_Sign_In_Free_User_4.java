package SetupClass.StepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SetupClass.SetupClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Email_Sign_In_Free_User_4 extends SetupClass {

	

	@Given("^user is already on Home Page of Geeks Website iv$")
	public void user_is_already_on_Home_Page_of_Geeks_Website_iv() throws Throwable {
		driver.get(AppURL);
		ClearBrowserCache();
		Thread.sleep(2000);
	}

	@Then("^user navigates to login page iv$")
	public void user_navigates_to_login_page_iv() throws Throwable {
		try {
			WebElement login_signin_btn = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Login']")));

			login_signin_btn.click();
			Thread.sleep(2000);
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^user login to website iv$")
	public void user_login_to_website_iv() throws Throwable {

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
		Thread.sleep(4000);
		String actual_URL = driver.getCurrentUrl();
		String expected_URL = "https://www.slidegeeks.com/subscriptions";
		Assert.assertEquals("user is not on the pricing page after login with free account", expected_URL, actual_URL);

	}

	@Then("^user signout of website iv$")
	public void user_signout_of_website_iv() throws Throwable {

		try {
			WebElement Signout = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("LOGOUT")));
			Thread.sleep(3000);
			Signout.click();
			System.out.println("Signout from the application");
		} catch (NoSuchElementException e) {

		}
	}

}
