import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class BasicAPITest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//given - all input details
		//when - submit the API (Resource and Http method)
		//then - validate the Response
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		given().log().all().queryParams("key", "qaclick123").headers("Content-Type", "application/json")
			.body("{\r\n"
				+ "    \"location\": {\r\n"
				+ "        \"lat\": -38.383494,\r\n"
				+ "        \"lng\": 33.427362\r\n"
				+ "    },\r\n"
				+ "    \"accuracy\": 50,\r\n"
				+ "\r\n"
				+ "    \"name\": \"Arendelle house\",\r\n"
				+ "    \"phone_number\": \"(+91) 1234567894\",\r\n"
				+ "    \"address\": \"29, side layout, cohen 099\",\r\n"
				+ "    \"types\": [\r\n"
				+ "        \"shoe park\",\r\n"
				+ "        \"shop\"\r\n"
				+ "    ],\r\n"
				+ "    \"website\": \"http://google.com\",\r\n"
				+ "    \"language\": \"French-IN\"\r\n"
				+ "}")
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200);
		
		
	}

}
