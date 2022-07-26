package SetupClass.StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SetupClass.SetupClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Email_Sign_In_Paid_User_5 extends SetupClass {

	@Given("^user is already on Home Page of Geeks Website v$")
	public void user_is_already_on_Home_Page_of_Geeks_Website_v() throws Throwable {
		driver.get(AppURL);
		ClearBrowserCache();
		Thread.sleep(2000);

	}

	@Then("^user navigates to login page v$")
	public void user_navigates_to_login_page_v() throws Throwable {
		try {
			WebElement login_signin_btn = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Login']")));
			Thread.sleep(3000);
			login_signin_btn.click();
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {

		}
	}

	@Then("^user login to website v$")
	public void user_login_to_website_v() throws Throwable {
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

	}

	@Then("^user is redirected my dashboard page v$")
	public void user_is_redirected_my_dashboard_page_v() throws Throwable {
		log.info("Hey, I am on Dashboard");
		String expected_URL = "https://www.slidegeeks.com/account";
		String actual_URL = driver.getCurrentUrl();

		Assert.assertEquals("user is not on the dashboard page after login with paid account", expected_URL,
				actual_URL);
	}

	@Then("^user download a paid product v$")
	public void user_download_a_paid_product_v() throws Throwable {

		// Click on popular PPT
		WebElement popular_PPt = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Most Popular']")));
		Thread.sleep(3000);
		popular_PPt.click();
		Thread.sleep(3000);

		// Select any of one PPT

		WebElement select_Ppt = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div[1]/div[1]/div[1]/a[1]/div[1]/img[1]")));
		Thread.sleep(3000);
		select_Ppt.click();
		Thread.sleep(3000);

		WebElement download_btn1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.linkText("Download this Presentation")));
		Thread.sleep(3000);
		download_btn1.click();
		Thread.sleep(3000);

	}

	@Then("^user signout of website v$")
	public void user_signout_of_website_v() throws Throwable {

		try {
			WebElement Signout = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("LOGOUT")));
			Thread.sleep(3000);
			System.out.println("Signout from the application");
			Signout.click();
		} catch (NoSuchElementException e) {

		}
	}
}
