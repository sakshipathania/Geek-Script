package SetupClass.StepDefinition;

import java.util.Random;
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

public class Email_Sign_up_Correct_Data_2 extends SetupClass {

	WebDriverWait wait = new WebDriverWait(driver, 50);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@Given("^user is already on Website Home Page ii$")
	public void user_is_already_on_Website_Home_Page_ii() throws Throwable {
		driver.get(AppURL);
		ClearBrowserCache();
		Thread.sleep(2000);

	}

	@Then("^user navigates to sign up page ii$")
	public void user_navigates_to_sign_up_page_ii() throws Throwable {

		try {
			WebElement login_signup_btn = wait
					.until(ExpectedConditions.elementToBeClickable(By.linkText("SIGNUP FOR FREE")));
			Thread.sleep(3000);
			login_signup_btn.click();
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {

		}
		// driver.get("https://www.slidegeeks.com/register");
		// Thread.sleep(3000);

	}

	@Then("^user enter name ii$")
	public void user_enter_name_ii() throws Throwable {

		WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#register_name")));
		name.sendKeys("Automated Program");

	}

	@Then("^user enter email ii$")
	public void user_enter_email_ii() throws Throwable {

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

	@Then("^user enter password and confirm password ii$")
	public void user_enter_password_and_confirm_password_ii() throws Throwable {

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

	@Then("^user enter captcha ii$")
	public void user_enter_captcha_ii() throws Throwable {

		WebElement captcha = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#captchtext")));
		Thread.sleep(3000);
		captcha.sendKeys("Y3Tt6bfwI");
		Thread.sleep(3000);

	}

	@Then("^user click on register button to complete sign up ii$")
	public void user_click_on_register_button_to_complete_sign_up_ii() throws Throwable {

		WebElement register_btn = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".pg-register-button-new")));
		Thread.sleep(3000);
		register_btn.click();
		Thread.sleep(5000);

		String actual_URL = driver.getCurrentUrl();
		String expected_URL = "https://www.slidegeeks.com/subscriptions";
		Assert.assertEquals("user is not on the pricing page after login with free account", expected_URL, actual_URL);

		WebElement free_Slides = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("FREE SLIDES")));
		free_Slides.click();

		// select PPT

		WebElement downloadPPt = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[2]/div[2]/div[1]/div[1]/div[1]/p[1]/a[1]/span[1]")));
		downloadPPt.click();

		try {
			WebElement Signout = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("LOGOUT")));
			Thread.sleep(3000);
			Signout.click();
			System.out.println("Signout from the application");
		} catch (NoSuchElementException e) {

		}

	}

}
