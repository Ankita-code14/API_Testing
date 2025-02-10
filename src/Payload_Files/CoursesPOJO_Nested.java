package Payload_Files;


import java.util.List;

public class CoursesPOJO_Nested {
	
	private List<WebAutomationCoursePOJO_NestedArrayJson> webAutomation;
	private List<APICoursePOJO_NestedArrayJson> api;
	private List<MobileCoursePOJO_NestedArrayJson> mobile;

	
	public List<WebAutomationCoursePOJO_NestedArrayJson> getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(List<WebAutomationCoursePOJO_NestedArrayJson> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<APICoursePOJO_NestedArrayJson> getApi() {
		return api;
	}
	public void setApi(List<APICoursePOJO_NestedArrayJson> api) {
		this.api = api;
	}
	public List<MobileCoursePOJO_NestedArrayJson> getMobile() {
		return mobile;
	}
	public void setMobile(List<MobileCoursePOJO_NestedArrayJson> mobile) {
		this.mobile = mobile;
	}

}
