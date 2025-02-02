import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import Payload_Files.Payloads;

public class AddPlaceAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//create different method for json payload
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		given().log().all().queryParams("key", "qaclick123").headers("Content-Type", "application/json").body(Payloads.addPlace())
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).headers("Server", "Apache/2.4.52 (Ubuntu)");
		
	}



}
