package com.practice.courses.webservice.soap.soapcoursemanagement.soap;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.practice.courses.CourseDetails;
import com.practice.courses.GetCourseDetailsRequest;
import com.practice.courses.GetCourseDetailsResponse;
import com.practice.courses.webservice.soap.soapcoursemanagement.soap.bean.Course;
import com.practice.courses.webservice.soap.soapcoursemanagement.soap.service.CourseDetailsService;



@Endpoint
public class CourseDetailsEndpoint {
	
	@Autowired
	CourseDetailsService service;
	
	@PayloadRoot(namespace="http://practice.com/courses",localPart = "GetCourseDetailsRequest") 
	@ResponsePayload
	public GetCourseDetailsResponse name(@RequestPayload GetCourseDetailsRequest request) {
		Course course = service.findByID(request.getId());
		return mapCourse(course);
		
	}

	private GetCourseDetailsResponse mapCourse(Course course) {
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(course.getId());
		courseDetails.setName(course.getName());
		courseDetails.setDescription(course.getDescription());
		response.setCourseDetails(courseDetails);
		return response;
	}

}
