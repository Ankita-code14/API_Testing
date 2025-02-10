import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;

import Payload_Files.GoogleMapPOJO;
import Payload_Files.GoogleMapPOJO_Location;
import Payload_Files.Payloads_Place;
import io.restassured.RestAssured;

public class POJOSerialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GoogleMapPOJO addPlacePayload = new GoogleMapPOJO();
		
		addPlacePayload.setAccuracy(50);
		addPlacePayload.setName("Arendelle house");
		addPlacePayload.setPhone_number("(+91) 1234567894");
		addPlacePayload.setAddress("29, side layout, cohen 099");
		addPlacePayload.setWebsite("http://google.com");
		addPlacePayload.setLanguage("French-IN");
		
		ArrayList<String> typesList = new ArrayList<String>();
		typesList.add("shoe park");
		typesList.add("shop");
		
		addPlacePayload.setTypes(typesList);
		
		GoogleMapPOJO_Location locObj = new GoogleMapPOJO_Location();
		locObj.setLat(-38.383494);
		locObj.setLng(33.427362);
		
		addPlacePayload.setLocation(locObj);
		
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		given().log().all().queryParams("key", "qaclick123").headers("Content-Type", "application/json")
		.body(addPlacePayload)
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200)
		.body("scope", equalTo("APP")).headers("Server", "Apache/2.4.52 (Ubuntu)");
		
		
	}

}
