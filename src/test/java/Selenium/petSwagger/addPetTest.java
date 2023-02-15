package Selenium.petSwagger;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonMappingException;


import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(org.testng.reporters.EmailableReporter.class)
public class addPetTest {

	 public WebDriver driver;
	public String data = "mathumathi";
	public static String pet_id ;


	
	
	@Test
	public void addPet() throws JsonMappingException, Exception {
		Random rand = new Random();
		int random = rand.nextInt(100)+1;
		driver = base.driver;
		driver.findElement(By.xpath("//*[@id='operations-pet-addPet']//button/span[@class='opblock-summary-method']")).click();
		driver.findElement(By.xpath("//*[@id='operations-pet-addPet']/div[@class='no-margin']//following-sibling::div[@class='try-out']")).click();
		
		WebElement addpetJson = driver.findElement(By.xpath("//*[@class='body-param__text']"));
		String json = addpetJson.getText();
		//System.out.println(json);
		addpetJson.clear();
		
		addpetJson.sendKeys("{\r\n"
				+ "  \"id\": "+random+",\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"" +data+ "\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}");
		

		driver.findElement(By.xpath("//div[@class='execute-wrapper']")).click();
	
		
		
		
	}
	@Test(dependsOnMethods= "addPet")
	public void responseBodyVerify() throws Exception {
		Thread.sleep(2000);
		String resStatus = driver.findElement(By.xpath("//table[@class='responses-table live-responses-table']/tbody/tr/td")).getText();
		System.out.println("Response status of created pet is "+resStatus);
		String resBody = driver.findElement(By.xpath("//*[@class='microlight']/code[@class='language-json']")).getText();
		System.out.println("Response body of created pet is " + resBody);
		pet_id = driver.findElement(By.xpath("//*[@class='language-json']/span[5]")).getText();
		System.out.println("Petswagger created ID " +pet_id);
	}
	
	

	
	
	
}
