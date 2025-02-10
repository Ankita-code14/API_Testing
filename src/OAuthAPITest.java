import static io.restassured.RestAssured.*;

import Utilis.Resuable_Methods;
import io.restassured.path.json.JsonPath;

public class OAuthAPITest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//all secure information should be pass through post call only
		
		
		//Get the Access Token from Authorization Server
		
		String serverResponse = given()
				.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.formParam("grant_type", "client_credentials")
				.formParam("scope", "trust")
				.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
		
		System.out.println(serverResponse);
		JsonPath js = Resuable_Methods.convertRowToJson(serverResponse);
		String accessToken = js.getString("access_token");
		
		String getResponse = given().queryParam("access_token", accessToken)
		.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").asString();
		
		System.out.println(getResponse);
		
		
	}

}
