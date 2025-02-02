import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import Payload_Files.Payloads;

public class ETE_POST_PUT_GET_PlaceAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//End To End - Create Place, Update Place, Get Place
		//Add Place - Update Place with New Address -> Get Place to validate if New Address is present in response 
		
		
		//extract response as a String
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		String response = given().queryParams("key", "qaclick123").headers("Content-Type", "application/json")
			.body(Payloads.addPlace())
		.when().post("maps/api/place/add/json")
		.then().extract().asString();
		
		System.out.println(response);
		
		//Using Json Path class for parsing the Json response and extract respective value
		
		JsonPath js = new JsonPath(response);
		String placeId = js.getString("place_id");
		
		System.out.println(placeId);
		
	}

}
