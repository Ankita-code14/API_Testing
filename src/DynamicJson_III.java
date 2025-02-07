import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Payload_Files.Payloads_Library;
import Utilis.Resuable_Methods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson_III {
	
	//parameterize the API Tests with multiple data sets ==> TestNg DataProvider 
	
	@Test(dataProvider="BooksData")
	public void addBook_TestNgDataProvider(String isbn, String aisle) {
		RestAssured.baseURI = "http://216.10.245.166";
		
		String addBookResponse = given().headers("Content-Type", "application/json").
				body(Payloads_Library.addBook_MethodParameters(isbn, aisle)).
				when().post("Library/Addbook.php").
				then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = Resuable_Methods.convertRowToJson(addBookResponse);
		js.get("ID");
		System.out.println(js.get("ID").toString());
	}
	
	@Test(dependsOnMethods ="addBook_TestNgDataProvider", dataProvider="BooksData")
	public void deleteBook_TestNgDataProvider(String isbn, String aisle ) {
		/*
		 * String id = isbn.concat(aisle); System.out.println(id);
		 */
		RestAssured.baseURI = "http://216.10.245.166";
		
		String deleteBookResponse = given().headers("Content-Type", "application/json").
				body(Payloads_Library.deleteBook__MethodParameters(isbn, aisle)).
				when().post("Library/DeleteBook.php").
				then().extract().response().asString();
		
		JsonPath js = Resuable_Methods.convertRowToJson(deleteBookResponse);
		js.getString("msg");
		System.out.println(js.getString("msg"));
	}
	
	@DataProvider(name = "BooksData")
	public Object[][] getData() {
		//array = collection of elements
		//Multidimessional array = collection of arrays
		
		return new Object[][] {{"1", "ffsdfsdf"}, {"2", "jhgf"}, {"3", "jhdfk"}};
	}

}
