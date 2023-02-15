package Selenium.petSwagger;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class browserLaunch extends base{

	@BeforeSuite
	public void browser() {
		base.driver = launch();
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}
