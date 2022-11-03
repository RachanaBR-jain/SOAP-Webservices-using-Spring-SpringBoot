package com.practice.courses.webservice.soap.soapcoursemanagement.soap;



import javax.servlet.ServletRegistration;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/*
 * Setps:
 * 1)Spring configuration by using @Configuration
 * 2)Enable Spring WebServices using @EnableWs
 */
@EnableWs
@Configuration
public class WebServiceConfiguration {
	
	// map DispacterServlet to URL using MessageDispacterServlet,application Context

	@Bean
	ServletRegistrationBean messageDispatcherServlet(org.springframework.context.ApplicationContext context) {
		// map messesgeDispater servlet to "/ws/*
		MessageDispatcherServlet messagedispacterServlet = new MessageDispatcherServlet();
		messagedispacterServlet.setApplicationContext(context);
		messagedispacterServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(messagedispacterServlet, "/ws/*");
	}
	
	
	
	//instance created by spring for coursesSchema will be used here , autowiring of dependency takes place
	//Spring must create wsdl with endpoint or location /ws/course.wsdl
	// port-type- courstPort
	// Targetnamespace - http://practice.soapWebservices.com/courses"
	// create bean for Schema - course-details.xsd - xsd file using XsdSchema
	@Bean(name="courses") 
	public DefaultWsdl11Definition defaultWsdl11Defination(XsdSchema coursesSchema) {
		DefaultWsdl11Definition defination = new DefaultWsdl11Definition();
		defination.setPortTypeName("CoursePort");
		defination.setTargetNamespace("http://practice.com/courses");
		defination.setLocationUri("/ws");
		defination.setSchema(coursesSchema);
		return defination;
		
	}
	@Bean
	public XsdSchema coursesSchema() {
		return new SimpleXsdSchema(new ClassPathResource("course-details.xsd"));
	}


}
