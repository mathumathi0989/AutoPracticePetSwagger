package Selenium.petSwagger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@Listeners(org.testng.reporters.EmailableReporter.class)
public class getPetAPITest {

addPetTest te = new addPetTest();

	@Test
	public void findPet() throws Exception {
		String respo = given().baseUri("https://petstore.swagger.io/v2/pet/"+ te.pet_id+"").contentType("application/json")
		.when().get().then().log().all().extract().response().asString();
	
		JsonPath jpath = new JsonPath(respo);
		
		int act_ID = jpath.get("id");
		String actual_ID = Integer.toString(act_ID);
		Assert.assertEquals(actual_ID, te.pet_id);
		
		
	}

	
	
	
	
}
