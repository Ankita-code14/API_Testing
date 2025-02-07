import org.testng.annotations.Test;

import Payload_Files.Payloads_Library;
import Utilis.Resuable_Methods;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson_I {

	@Test
	public void addBook() {
		RestAssured.baseURI = "http://216.10.245.166";
		
		String addBookResponse = given().headers("Content-Type", "application/json").
		body(Payloads_Library.addBook()).
		when().post("Library/Addbook.php").
		then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = Resuable_Methods.convertRowToJson(addBookResponse);
		js.get("ID"); //by default get method use String
		System.out.println(js.get("ID").toString());
		
	}
	
	
	/*
	 * Advanced Dynamic Payload Creation Strategies
	 * 
	 * Dynamically build json payload with external data inputs ==> Using Parameterize Methods 
	 * parameterize the API Tests with multiple data sets ==> TestNg DataProvider 
	 * How to send static Json files(payload) directly into Post Method of Rest Assured 
	 * Feed Json Payload from Using Excel using HashMap 
	 * POJO classes to build payload
	 */
	
	/*
	 * Static Payload Creation
	 * 
	 * Pass json in Body() method 
	 * Create another Method in different class and call through method
	 * How to send static Json files(payload) directly into Post Method of Rest Assured 
	 */
	
	
}
