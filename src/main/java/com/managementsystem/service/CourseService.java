package com.managementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managementsystem.dao.CourseDAO;
import com.managementsystem.entities.Classroom;
import com.managementsystem.entities.Course;

@Service
public class CourseService {

	@Autowired
	private CourseDAO courseDAO;

	public Course updateCourses(int id, Course course) {
		Course existingCourse = courseDAO.getCoursesById(id);
		existingCourse.setName(course.getName());

		courseDAO.updateCourses(existingCourse);

		return existingCourse;

	}

	public List<Course> getAllCourses() {
		
		return courseDAO.getAllCourses();
	}

	public Course getCoursesById(int id) {
		// TODO Auto-generated method stub
		return courseDAO.getCoursesById(id);
	}

	public String createCourses(Course course) {
		// TODO Auto-generated method stub
		return courseDAO.createCourses(course);
	}

	public String deleteCoursesById(int id) {
		// TODO Auto-generated method stub
		return courseDAO.deleteCoursesById(id);
	}
}
