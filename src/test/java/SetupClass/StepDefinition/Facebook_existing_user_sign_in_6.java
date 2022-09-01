package SetupClass.StepDefinition;

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

public class Facebook_existing_user_sign_in_6 extends SetupClass {

	WebDriverWait wait = new WebDriverWait(driver, 30);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@Given("^user is already on Home Page of Geeks Website vi$")
	public void user_is_already_on_Home_Page_of_Geeks_Website_vi() throws Throwable {
		ClearfacebookCache();
		driver.get(AppURL);
		ClearBrowserCache();
		Thread.sleep(3000);
	}

	@Then("^user navigates to fb login page vi$")
	public void user_navigates_to_login_page_vi() throws Throwable {
		WebElement fb_login_btn = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#facebook-signin-btn > i")));
		Thread.sleep(3000);
		fb_login_btn.click();
		Thread.sleep(3000);
	}

	@Then("^user login to website vi$")
	public void user_login_to_website_vi() throws Throwable {

		driver.manage().window().maximize();
		// String handle = " ";
		String currentWindow = driver.getWindowHandle();
		String popupWindowHandle = null;

		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(currentWindow)) {

				popupWindowHandle = handle;
				driver.switchTo().window(popupWindowHandle);
				driver.manage().window().maximize();

				Thread.sleep(3000);

				WebElement fb_email = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
				// Thread.sleep(3000);
				fb_email.clear();
				fb_email.sendKeys("slidetech.qa@gmail.com");
				Thread.sleep(3000);
				WebElement fb_pass = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='pass']")));
				// Thread.sleep(3000);
				fb_pass.clear();
				fb_pass.sendKeys("himanshi@123");

				Thread.sleep(3000);
				// WebElement fb_login_btn2 =
				// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("*//input[contains(@value,'Log
				// In')]")));
				// fb_login_btn2.click();
				Thread.sleep(3000);
				try {
					if (!driver.findElements(By.xpath("//input[@value='Log In']")).isEmpty()) {
						driver.findElement(By.xpath("//input[@value='Log In']")).click();
					} else {
						WebElement fb_login = wait.until(
								ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='loginbutton']")));

						fb_login.click();
						Thread.sleep(3000);
					}
				} catch (NoSuchElementException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// to verify the continue button
				// button[normalize-space()='Yes, Continue']

			}
		}
		driver.switchTo().window(currentWindow);
	}

	@Then("^user is redirected my dashboard page vi$")
	public void user_is_redirected_my_dashboard_page_vi() throws Throwable {
		log.info("Hey, I am on Pricing");
	}

	@Then("^user download a paid product vi$")
	public void user_download_a_paid_product_vi() throws Throwable {

		Thread.sleep(4000);
		System.out.println("page = " + driver.getCurrentUrl());
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

	@Then("^user signout of website vi$")
	public void user_signout_of_website_vi() throws Throwable {

		String pp_page_title = driver.getTitle();
		System.out.println("Title of the Page is --> " + pp_page_title);
		Thread.sleep(1000);

		try {
			WebElement Signout = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("LOGOUT")));
			Thread.sleep(3000);
			Signout.click();
			System.out.println("Logout click successfully");

		} catch (NoSuchElementException e) {

		}

	}
}
