package Selenium.petSwagger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	 public  WebDriver driver;
	
	public static WebDriver launch() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://petstore.swagger.io/");
		driver.manage().window().maximize();
		return driver;
	
		
	}
	
}
