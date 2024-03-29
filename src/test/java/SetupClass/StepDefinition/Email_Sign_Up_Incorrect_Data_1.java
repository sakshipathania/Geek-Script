package SetupClass.StepDefinition;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SetupClass.SetupClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Email_Sign_Up_Incorrect_Data_1 extends SetupClass {

	
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@Given("^user is already on Website Home Page i$")
	public void user_is_already_on_Website_Home_Page_i() throws Throwable {
		driver.get(AppURL);
		ClearBrowserCache();
		Thread.sleep(2000);

	}

	@Then("^user navigates to sign up page i$")
	public void user_navigates_to_sign_up_page_i() throws Throwable {
		try {
			WebElement login_signup_btn = wait
					.until(ExpectedConditions.elementToBeClickable(By.linkText("SIGNUP FOR FREE")));
			Thread.sleep(3000);
			login_signup_btn.click();
			Thread.sleep(3000);
			driver.get("https://www.slidegeeks.com/register?103=918");
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {

		}

	}

	@Then("^user enter incorrect details to sign up i$")
	public void user_enter_incorrect_details_to_sign_up_i() throws Throwable {

		WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#register_name")));
		Thread.sleep(3000);
		name.sendKeys("hello moto");
		Thread.sleep(3000);

		WebElement new_email = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#register_email")));
		Thread.sleep(3000);
		new_email.sendKeys("%^YMNGDJMWSD");
		Thread.sleep(3000);

		WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#register_password")));
		Thread.sleep(3000);
		password.sendKeys("Ghdcjkdshc123");
		Thread.sleep(3000);

		WebElement confirm_passwoed = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#register_password2")));
		Thread.sleep(3000);
		confirm_passwoed.sendKeys("Gedfjksahbjeks@123");
		Thread.sleep(3000);

		/*
		 * WebElement captcha =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
		 * "#captchtext"))); Thread.sleep(3000); captcha.sendKeys("12345");
		 * Thread.sleep(3000);
		 */

		WebElement register_btn = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".pg-register-button-new")));
		Thread.sleep(3000);
		register_btn.click();
		Thread.sleep(3000);
		driver.get("https://www.slidegeeks.com/register?303=918");
		Thread.sleep(3000);

	}

	@Then("^error message is displayed i$")
	public void error_message_is_displayed_i() throws Throwable {

		WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#register_name")));
		Thread.sleep(3000);
		name.clear();

		WebElement new_email = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#register_email")));

		Thread.sleep(3000);
		new_email.clear();
		Thread.sleep(3000);

		WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#register_password")));
		Thread.sleep(3000);
		password.clear();
		Thread.sleep(3000);

		WebElement confirm_passwoed = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#register_password2")));
		Thread.sleep(3000);
		confirm_passwoed.clear();
		Thread.sleep(3000);

		/*
		 * WebElement captcha =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
		 * "#captchtext"))); Thread.sleep(3000); captcha.clear(); Thread.sleep(3000);
		 */

	}

	@Then("^user enter valid name i$")
	public void user_enter_valid_name_i() throws Throwable {

		WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#register_name")));
		Thread.sleep(3000);
		name.sendKeys("Automated Program");
		Thread.sleep(3000);

	}

	@Then("^user enter valid email i$")
	public void user_enter_valid_email_i() throws Throwable {
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
	}

	@Then("^user enter valid password and confirm password i$")
	public void user_enter_valid_password_and_confirm_password_i() throws Throwable {

		WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#register_password")));
		Thread.sleep(3000);
		password.sendKeys("Geeks@123");
		Thread.sleep(3000);

		WebElement confirm_passwoed = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#register_password2")));
		Thread.sleep(3000);
		confirm_passwoed.sendKeys("Geeks@123");
		Thread.sleep(3000);
	}

	@Then("^user enter valid captcha i$")
	public void user_enter_valid_captcha_i() throws Throwable {

		/*
		 * WebElement captcha =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
		 * "#captchtext"))); Thread.sleep(3000); captcha.sendKeys("Y3Tt6bfwI");
		 * Thread.sleep(3000);
		 */
	}

	@Then("^user click on register button to complete sign up i$")
	public void user_click_on_register_button_to_complete_sign_up_i() throws Throwable {

		WebElement register_btn = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".pg-register-button-new")));
		Thread.sleep(3000);
		register_btn.click();
		Thread.sleep(5000);

		WebElement free_Slides = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("FREE SLIDES")));
		free_Slides.click();

		// select PPT

		WebElement downloadPPt = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[2]/div[2]/div[1]/div[1]/div[1]/p[1]/a[1]/span[1]")));
		downloadPPt.click();
		Thread.sleep(3000);

		try {
			WebElement Signout = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("LOGOUT")));
			Thread.sleep(3000);
			js.executeScript("arguments[0].click();", Signout);
			System.out.println("Signout from the application");
		} catch (NoSuchElementException e) {

		}
	}

}
