package com.practice.courses.webservice.soap.soapcoursemanagement.soap;



import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.practice.courses.CourseDetails;
import com.practice.courses.GetCourseDetailsRequest;
import com.practice.courses.GetCourseDetailsResponse;



@Endpoint
public class CourseDetailsEndpoint {
	//create method which takes input as request object and output as response object
	//@payloadRoot will accept the  http://practice.soapWebservices.com/course with GetCourseDetailsRequest
	//@RequestPayload will convert GetCourseDetailsRequest xml to java object
	//@ResponsePayload will covert java opject response to xml type
	
	@PayloadRoot(namespace="http://practice.com/courses",localPart = "GetCourseDetailsRequest") 
	@ResponsePayload
	public GetCourseDetailsResponse name(@RequestPayload GetCourseDetailsRequest request) {
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(request.getId());
		courseDetails.setName("Microservices Course");
		courseDetails.setDescription("Learn and upskill-its a wonderfull course!");
		response.setCourseDetails(courseDetails);
		return response;
		
	}

}
