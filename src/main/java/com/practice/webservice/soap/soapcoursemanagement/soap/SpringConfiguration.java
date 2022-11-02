package com.practice.webservice.soap.soapcoursemanagement.soap;

import javax.servlet.ServletRegistration;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

/*
 * Setps:
 * 1)Spring configuration by using @Configuration
 * 2)Enable Spring WebServices using @EnableWs
 */
@EnableWs
@Configuration
public class SpringConfiguration {
	// map DispacterServlet to URL using MessageDispacterServlet,application Context

	@Bean
	ServletRegistrationBean messageDispatcherServlet(org.springframework.context.ApplicationContext context) {
		// map messesgeDispater servlet to "/ws/*
		MessageDispatcherServlet messagedispacterServlet = new MessageDispatcherServlet();
		messagedispacterServlet.setApplicationContext(context);
		messagedispacterServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(messagedispacterServlet, "/ws/*");

	}

}
