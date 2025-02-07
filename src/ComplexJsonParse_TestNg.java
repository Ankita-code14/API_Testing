import org.testng.Assert;
import org.testng.annotations.Test;
import Payload_Files.Payloads_CourseDetails;
import Utilis.Resuable_Methods;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse_TestNg {

	@Test
	public void getNoOfCourses() {
		JsonPath js = Resuable_Methods.convertRowToJson(Payloads_CourseDetails.courseDetails());
		int count = js.getInt("courses.size()");
		System.out.println("No of courses returned by API : "+count);
	}
	
	@Test
	public void getPuarchaseAmout() {
		JsonPath js = Resuable_Methods.convertRowToJson(Payloads_CourseDetails.courseDetails());
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println("Purchase Amount : "+purchaseAmount);
	}
	
	@Test
	public void getFirstCourseTitle() {
		JsonPath js = Resuable_Methods.convertRowToJson(Payloads_CourseDetails.courseDetails());
		String firstCourseTitle = js.getString("courses[0].title");
		System.out.println("Title of the first course : "+firstCourseTitle);
	}
	
	@Test
	public void getAllCoursesTitleAndPrice() {
		JsonPath js = Resuable_Methods.convertRowToJson(Payloads_CourseDetails.courseDetails());
		for(int i=0; i<3; i++) {
			System.out.println("Course Title : "+ js.getString("courses["+i+"].title") + ", Course Price : "+ js.getInt("courses["+i+"].price"));
		}
	}
	
	@Test
	public void getNoOfCopiesSoldByCourse() {
		JsonPath js = Resuable_Methods.convertRowToJson(Payloads_CourseDetails.courseDetails());
		for(int i=0; i<js.getInt("courses.size()"); i++) {
			if(js.getString("courses["+i+"].title").equalsIgnoreCase("RPA")) {
				System.out.println("no of copies sold by RPA Course : "+ js.getInt("courses["+i+"].copies"));
				break; 
			}
		}
	}
	
	@Test
	public void verifySumOfAllCoursesWithPurchaseAmount() {
		JsonPath js = Resuable_Methods.convertRowToJson(Payloads_CourseDetails.courseDetails());
		int totalCoursePrice = 0;
		for(int i=0; i<js.getInt("courses.size()"); i++) {
			totalCoursePrice = totalCoursePrice + (js.getInt("courses["+i+"].price") * (js.getInt("courses["+i+"].copies")));
		}
		System.out.println(totalCoursePrice);
		Assert.assertEquals(js.getInt("dashboard.purchaseAmount"), totalCoursePrice);
	}
}
