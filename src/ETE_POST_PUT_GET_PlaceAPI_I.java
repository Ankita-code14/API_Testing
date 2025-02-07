import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;
import static io.restassured.RestAssured.*;
import Payload_Files.Payloads_Place;
import Utilis.Resuable_Methods;

public class ETE_POST_PUT_GET_PlaceAPI_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//End To End - Create Place, Update Place, Get Place
		//Add Place - Update Place with New Address -> Get Place to validate if New Address is present in response 
		//
		
	
		//extract response as a String
		
		String keyValue = "qaclick123";
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		String addplace_Response = given().queryParams("key", keyValue).headers("Content-Type", "application/json")
			.body(Payloads_Place.addPlace())
		.when().post("maps/api/place/add/json")
		.then().extract().asString();
		
		System.out.println(addplace_Response);
		
		//Using Json Path class for parsing the Json response and extract respective value
		
		JsonPath js = Resuable_Methods.convertRowToJson(addplace_Response); //using resuable convertresponsetojson method
		String placeId = js.getString("place_id");
		
		System.out.println(placeId);
		
		//Update place API
		
		String newAddress = "Arendelle house, Canada";
		
		given().queryParams("key", keyValue).headers("Content-Type", "application/json")
			.body(Payloads_Place.updatePlace(placeId, newAddress, keyValue))
		.when().put("maps/api/place/update/json")
		.then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated")); //Assert using restassured method 
		
		
		//Get Place API
		
		String getPlace_Response = given().queryParams("key", keyValue, "place_id", placeId)
		.when().get("maps/api/place/get/json")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js1 = Resuable_Methods.convertRowToJson(getPlace_Response);//using resuable convertresponsetojson method
		String actualAdd = js1.getString("address");
		
		System.out.println(actualAdd);
		
		Assert.assertEquals(actualAdd, newAddress); //assert using testng method
	}

}

