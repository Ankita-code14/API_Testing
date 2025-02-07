package Payload_Files;

public class Payloads_Place {

	public static String addPlace() {
		return "{\r\n"
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
				+ "}";
	}
	
	public static String updatePlace(String placeId, String address, String keyValue) {
		
		return "{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\""+address+"\",\r\n"
				+ "\"key\":\""+keyValue+"\"\r\n"
				+ "}";
		
	}
	
}
