package Selenium.petSwagger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class test2_API extends test1 {


	public test2_API() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}



	@Test
	public void findPet() throws Exception {
		
		String respo = given().log().all().baseUri("https://petstore.swagger.io/v2/pet/"+pet_id+"").contentType("application/json").queryParam("petID", pet_id)
		.when().get().then().log().all().extract().response().asString();
	
		JsonPath jpath = new JsonPath(respo);
		
		int act_ID = jpath.get("id");
		String actual_ID = Integer.toString(act_ID);
		System.out.println("actual id " +actual_ID);
		System.out.println("pet id is "+pet_id);
		Assert.assertEquals(actual_ID, pet_id);
		
		
	}

	
	
	
	
}
