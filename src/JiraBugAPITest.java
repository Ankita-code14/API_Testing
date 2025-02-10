import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import Utilis.Resuable_Methods;

public class JiraBugAPITest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestAssured.baseURI = "https://ankita14shikhare.atlassian.net";
		
		String createIssueResponse = given().header("Content-Type", "application/json")
			.header("Authorization", "Basic YW5raXRhMTRzaGlraGFyZUBnbWFpbC5jb206QVRBVFQzeEZmR0YwaDl4OG9PeEh4ZFVjeXhGTnJ5WlJYYnpkb2tUZ19PUlozZm1SR0taclp6SXZMR2gzVkdleVJLdjUwRnBzTUtSMjUwRGlwc0dPM1A1M3hISFdjVTB3R0RxcC05bmxzN0JXU25GUDNVc0dVbVBBeHZKd1gtaXFZVWpOakR2ZWtLTURIU09wbFhsT2c0T0U0QVFya1FFUExVQ0NlS0lUdjNUNUhJSC1OcTh2QnRzPTU2RTE3OURC")
		.body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "       \"project\":\r\n"
				+ "       {\r\n"
				+ "          \"key\": \"SCRUM\"\r\n"
				+ "       },\r\n"
				+ "       \"summary\": \"Input field are not working.-Automation\",\r\n"
				+ "       \"issuetype\": {\r\n"
				+ "          \"name\": \"Bug\"\r\n"
				+ "       }\r\n"
				+ "   }\r\n"
				+ "}")
		.post("rest/api/3/issue").then().assertThat().statusCode(201)
		.extract().response().asString();
		
		JsonPath js = Resuable_Methods.convertRowToJson(createIssueResponse);
		String issueId = js.getString("id");
		
		System.out.println(issueId);
		
	}

}
