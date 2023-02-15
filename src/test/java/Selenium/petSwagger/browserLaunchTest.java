package Selenium.petSwagger;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners(org.testng.reporters.EmailableReporter.class)
public class browserLaunchTest extends base{

	@BeforeSuite
	public void browser() {
		base.driver = launch();
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
