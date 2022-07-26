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

public class Email_Sign_In_Incorrect_Data_3 extends SetupClass {

	

	@Given("^user is already on Home Page of Geeks Website iii$")
	public void user_is_already_on_Home_Page_of_Geeks_Website_iii() throws Throwable {
		driver.get(AppURL);
		ClearBrowserCache();
		Thread.sleep(2000);

	}

	@Then("^user navigates to login page iii$")
	public void user_navigates_to_login_page_iii() throws Throwable {
		try {
			WebElement login_signin_btn = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Login']")));
			Thread.sleep(3000);
			login_signin_btn.click();
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {

		}

	}

	@Then("^user login to website with invalid email and password iii$")
	public void user_login_to_website_with_invalid_email_and_password_iii() throws Throwable {

		WebElement login_email = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='E-mail Address']")));
		Thread.sleep(3000);

		login_email.sendKeys("hkjfujsid@hsujrf.hjsdgf");
		Thread.sleep(3000);

		WebElement login_password = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Password']")));
		Thread.sleep(3000);
		login_password.sendKeys("12#@#@#3456");
		Thread.sleep(3000);

		WebElement login_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='Submit']")));
		Thread.sleep(3000);
		login_btn.click();
		Thread.sleep(3000);

	}

	@Then("^validate the error message iii$")
	public void validate_the_error_message_iii() throws Throwable {

		// driver.get(AppURL);
		// Thread.sleep(2000);
		// No validation message comes in geeks application after entreing wrong
		// username and password.

	}

	@Then("^user login to website with valid email and password iii$")
	public void user_login_to_website_with_valid_email_and_password_iii() throws Throwable {

		WebElement old_paid_email1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='E-mail Address']")));
		old_paid_email1.sendKeys("aknewsg1991@gmail.com");
		Thread.sleep(3000);
		WebElement old_paid_pass1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Password']")));
		old_paid_pass1.sendKeys("1234567");

		Thread.sleep(3000);
		WebElement old_paid_login_btn1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='Submit']")));
		old_paid_login_btn1.click();
		Thread.sleep(4000);
		// verify the page after login

		String expected_URL = "https://www.slidegeeks.com/account";
		String actual_URL = driver.getCurrentUrl();

		Assert.assertEquals("user is not on the dashboard page after login with paid account", expected_URL,
				actual_URL);

		// Click on popular PPT
		WebElement popular_PPt = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Most Popular']")));
		Thread.sleep(3000);
		popular_PPt.click();
		Thread.sleep(3000);

		// Select any of one PPT

		WebElement select_Ppt = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div[1]/div[1]/div[1]/a[1]/div[1]/img[1]")));
		Thread.sleep(3000);
		select_Ppt.click();
		Thread.sleep(3000);

		WebElement download_btn1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.linkText("Download this Presentation")));
		Thread.sleep(3000);
		download_btn1.click();
		Thread.sleep(3000);

		try {
			WebElement Signout = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("LOGOUT")));
			Thread.sleep(3000);
			Signout.click();
		} catch (NoSuchElementException e) {

		}
	}

}
