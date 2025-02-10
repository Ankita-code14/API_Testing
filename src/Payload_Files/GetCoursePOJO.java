package Payload_Files;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) //To handle UnrecognizedPropertyException by
//Disabling the object mapper to deserialize on unknown
//properties.

public class GetCoursePOJO {
	
	private String instructor;
	private String url;
	private String services;
	private String expertise;
	private CoursesPOJO_Nested courses;
	private String linkedIn;
	
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public CoursesPOJO_Nested getCourses() {
		return courses;
	}
	public void setCourses(CoursesPOJO_Nested courses) {
		this.courses = courses;
	}
	public String getLinkediIn() {
		return linkedIn;
	}
	public void setLinkedin(String linkedIn) {
		this.linkedIn = linkedIn;
	}

}
