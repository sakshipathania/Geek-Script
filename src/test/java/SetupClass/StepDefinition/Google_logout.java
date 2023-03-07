package SetupClass.StepDefinition;

import org.openqa.selenium.support.ui.WebDriverWait;

import SetupClass.SetupClass;
import io.cucumber.java.en.Given;

public class Google_logout extends SetupClass {

	

	@Given("^open the google plus page\\.$")
	public void open_the_google_plus_page() throws InterruptedException {
		Thread.sleep(3000);
		driver.get("https://mail.google.com");
		Thread.sleep(5000);
		driver.manage().deleteAllCookies();
		Thread.sleep(8000);

	}

}
