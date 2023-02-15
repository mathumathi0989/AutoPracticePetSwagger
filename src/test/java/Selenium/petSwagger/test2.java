package Selenium.petSwagger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class test2 extends base {

//	public WebDriver driver;
	
	test1 t = new test1();
	public WebDriver driver;

	
	@Test()
	public void findPet() throws Exception {
		driver = base.driver;
	
		System.out.println("apet id is " +t.pet_id);
		
		driver.findElement(By.xpath("//*[@class='opblock-summary opblock-summary-get']/button/span[@data-path='/pet/{petId}']//preceding-sibling::span")).click();
		driver.findElement(By.xpath("//div[@class='try-out']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//table[@class='parameters']/tbody/tr/td[2]/input")).sendKeys(t.pet_id);
		driver.findElement(By.xpath("//div[@class='execute-wrapper']/button")).click();
		
		
		
		
	}
	@Test(dependsOnMethods= "findPet")
	public void responseBodyVerify() throws Exception {
		Thread.sleep(2000);
		String resStatus = driver.findElement(By.xpath("//table[@class='responses-table live-responses-table']/tbody/tr/td")).getText();
		System.out.println("Without API" +resStatus);
		String resBody = driver.findElement(By.xpath("//*[@class='microlight']/code[@class='language-json']")).getText();
		System.out.println("Without API is"+resBody);
	
	}
	
	
	
	
}
