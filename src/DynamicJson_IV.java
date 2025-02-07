import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DynamicJson_IV {
	
	//How to send static Json files(payload) directly into Post Method of Rest Assured
	
	//Process = Content of the file to String ->  Content of file can convert to Byte -> Byte data to String
	
	//new String(Files.readAllBytes(Paths.get("file full path")))
	
	@Test
	public void addPlace_StaticJsonFile() throws IOException {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
	
		given().log().all().queryParams("key", "qaclick123").headers("Content-Type", "application/json")
		.body(new String(Files.readAllBytes(Paths.get("D:\\Ankita\\eclipse_workspace\\RSA_APITesting_I\\src\\Payload_Files\\AddPlace_StaticJson.json"))))
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200);
	
	
	}

}
