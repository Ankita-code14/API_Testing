import org.testng.Assert;
import org.testng.annotations.Test;

import Payload_Files.Payloads_Library;
import Utilis.Resuable_Methods;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson_II {
	
	// Dynamically build json payload with external data inputs ==> Using Parameterize Methods 
	
	@Test
	public void addBook_UsingMethodParameterPass() {
		RestAssured.baseURI = "http://216.10.245.166";
		
		//Add Book
		String addBookResponse = given().headers("Content-Type", "application/json").
				body(Payloads_Library.addBook_MethodParameters("54", "dgdg")).
				when().post("Library/Addbook.php").
				then().log().all().statusCode(200).extract().response().asString();
		
		JsonPath js = Resuable_Methods.convertRowToJson(addBookResponse);
		String id = js.get("ID");
		System.out.println(js.get("ID").toString());
		
		
		//Delete Book
		String deleteBookResponse = given().headers("Content-Type", "application/json").
				body(Payloads_Library.deleteBook(id)).
				when().post("Library/DeleteBook.php").
				then().extract().response().asString();
		
		JsonPath js1 = Resuable_Methods.convertRowToJson(deleteBookResponse);
		js1.getString("msg");
		System.out.println(js1.getString("msg"));
		
		Assert.assertEquals(js1.getString("msg"), "book is successfully deleted");
	}

}
