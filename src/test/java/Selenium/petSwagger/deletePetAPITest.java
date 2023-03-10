package Selenium.petSwagger;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import POJO.deletePOJO;

@Listeners(org.testng.reporters.EmailableReporter.class)
public class deletePetAPITest {

	addPetTest te = new addPetTest();
	
	@Test
	public void removePet() {
		
		deletePOJO repo = given().baseUri("https://petstore.swagger.io/v2/pet/"+ te.pet_id+"").contentType("application/json")
		.when().delete().as(deletePOJO.class);
		
		int code = repo.getCode();
		Assert.assertEquals(code, 200);
		
		repo.getType();
		
		String message = repo.getMessage();
		Assert.assertEquals(message, te.pet_id);
		
		
		
	}
	
	
	
	
	
}
