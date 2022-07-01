package SetupClass.StepDefinition;

import org.openqa.selenium.support.ui.WebDriverWait;

import SetupClass.SetupClass;
import io.cucumber.java.en.Given;

public class facebook_logout extends SetupClass {
	WebDriverWait wait = new WebDriverWait(driver, 50);

	@Given("^navigate to the facebook url\\.$")
	public void navigate_to_the_facebook_url() throws InterruptedException {

		driver.get("https://www.facebook.com");
		Thread.sleep(5000);
		driver.manage().deleteAllCookies();
	}

}
