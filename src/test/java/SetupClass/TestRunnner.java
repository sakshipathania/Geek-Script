package SetupClass;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"."}, //tags= {"@New_user_sign_in_via_google"},
plugin= {"pretty","html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json","usage:target/usage.jsonx","junit:target/cucumber.xml"})


public class TestRunnner {

	@BeforeClass
	public static void beforeClass() throws Exception {
		SetupClass.before_Class();
	}

	@AfterClass
	public static void afterClass() throws Exception {
		SetupClass.after_Class();
	}

}
