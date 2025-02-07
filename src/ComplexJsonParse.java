import io.restassured.path.json.JsonPath;

import org.testng.Assert;

import Payload_Files.Payloads_CourseDetails;
import Utilis.Resuable_Methods;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//When any API is not ready and we need to continue our API Automation Test then we will create Mock API response
		// once real API is ready by developer then we will use that api and get response out of it
		
		//JsonPath js = new JsonPath(Payloads_CourseDetails.courseDetails()); //Simple way to Parse response to JSONPath
		
		JsonPath js = Resuable_Methods.convertRowToJson(Payloads_CourseDetails.courseDetails()); //Another way to use resuable method for parsing response to JsonPath
		
		
		
		//1. Print No of courses returned by API
		
		int count = js.getInt("courses.size()"); // size() is used to get count of arrays as courses is array 
		System.out.println("No of courses returned by API : "+count);

		//2.Print Purchase Amount
		
		int purchaseAmount = js.getInt("dashboard.purchaseAmount.");
		System.out.println("Purchase Amount : "+purchaseAmount);

		//3. Print Title of the first course
		String firstCourseTitle = js.getString("courses[0].title");
		System.out.println("Title of the first course : "+firstCourseTitle);

		//4. Print All course titles and their respective Prices
		for(int i=0; i<3; i++) {
			System.out.println("Course Title : "+ js.getString("courses["+i+"].title") + ", Course Price : "+ js.getInt("courses["+i+"].price"));
		}

		//5. Print no of copies sold by RPA Course
		for(int i=0; i<count; i++) {
			if(js.getString("courses["+i+"].title").equalsIgnoreCase("RPA")) {
				System.out.println("no of copies sold by RPA Course : "+ js.getInt("courses["+i+"].copies"));
				break; 
			}
		}
		

		//6. Verify if Sum of all Course prices matches with Purchase Amount
		
		int totalCoursePrice = 0;
		
		for(int i=0; i<count; i++) {
			
			totalCoursePrice = totalCoursePrice + (js.getInt("courses["+i+"].price") * (js.getInt("courses["+i+"].copies")));
			
		}
		System.out.println(totalCoursePrice);
		
		Assert.assertEquals(purchaseAmount, totalCoursePrice);
	}

}
