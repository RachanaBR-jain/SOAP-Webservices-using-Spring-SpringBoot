package com.practice.courses.webservice.soap.soapcoursemanagement.soap.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.practice.courses.webservice.soap.soapcoursemanagement.soap.bean.Course;

@Component
public class CourseDetailsService {

	/*
	 * 3 function findByID(int id) -> retun courseName findAll<course>
	 * ->List<Course> deleteByID(int id) -> int 0/1
	 */
	private static List<Course> courses = new ArrayList<>();

	static {
		Course course1 = new Course(1, "Java", "Core, DS");
		courses.add(course1);
		Course course2 = new Course(2, "Spring-Core", "Basic");
		courses.add(course2);
		Course course3 = new Course(3, "Spring-MVC", "for web application");
		courses.add(course3);
		Course course4 = new Course(4, "Spring-Boot", "quickly produce production ready application ");
		courses.add(course4);
	}

	public Course findByID(int id) {

		for (Course course : courses) {
			if (course.getId() == id)
				return course;
		}
		return null;
	}

	public List<Course> findAll() {
		return courses;

	}

	public int deleteByID(int id) {
		/*
		 * } Iterator<Course> iterator = courses.iterator(); while (iterator.hasNext())
		 * { Course course = iterator.next(); if(course.getId() == id) {
		 * iterator.remove(); return 1; } return 0; }
		 */

		for (Course course : courses) {
			if (course.getId() == id) {
				courses.remove(id);
			}
			return 1;

		}
		return 0;
	}
	// USING ITERATOR
	

}
