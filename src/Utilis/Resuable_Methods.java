package Utilis;

import io.restassured.path.json.JsonPath;

public class Resuable_Methods {
	
	public static JsonPath convertRowToJson(String response) {
		JsonPath js = new JsonPath(response);
		return js;
	}

}
