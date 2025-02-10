import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import Payload_Files.APICoursePOJO_NestedArrayJson;
import Payload_Files.GetCoursePOJO;
import Payload_Files.WebAutomationCoursePOJO_NestedArrayJson;
import Utilis.Resuable_Methods;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

public class POJODeserialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] webAutomationCoursesTitles = {"Selenium Webdriver Java", "Cypress", "Protractor"};

		String serverResponse = given()
				.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.formParam("grant_type", "client_credentials")
				.formParam("scope", "trust")
				.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
		
		System.out.println(serverResponse);
		JsonPath js = Resuable_Methods.convertRowToJson(serverResponse);
		String accessToken = js.getString("access_token");
		
		GetCoursePOJO getResponse = given().queryParam("access_token", accessToken).expect().defaultParser(Parser.JSON)
		.when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetCoursePOJO.class);
		
		System.out.println(getResponse.getInstructor());
		System.out.println(getResponse.getLinkediIn());
		
		
		System.out.println(getResponse.getCourses().getApi().get(1).getCourseTitle()); //index hardcore
		
		List<APICoursePOJO_NestedArrayJson> apiCourses = getResponse.getCourses().getApi();
		for(int i=0; i<apiCourses.size(); i++) {
			if(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")) {
				System.out.println(apiCourses.get(i).getCourseTitle());
				System.out.println(apiCourses.get(i).getPrice());
			}
		}
		
		List<String> actualWebAutomationCoursesTitle = new ArrayList<String>();
		
		List<WebAutomationCoursePOJO_NestedArrayJson> webAutomationCourses = getResponse.getCourses().getWebAutomation();
		for(WebAutomationCoursePOJO_NestedArrayJson courses : webAutomationCourses) {
			System.out.println(courses.getCourseTitle()+" = "+courses.getPrice());
			actualWebAutomationCoursesTitle.add(courses.getCourseTitle());
		}

		List<String> expectedWebAutomationCoursesTitle =Arrays.asList(webAutomationCoursesTitles);
		
		Assert.assertTrue(actualWebAutomationCoursesTitle.equals(expectedWebAutomationCoursesTitle));
		
		
	}

}
