package com.managementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.managementsystem.dao.CourseDAO;
import com.managementsystem.entities.Classroom;
import com.managementsystem.entities.Course;
import com.managementsystem.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		
		return courseService.getAllCourses();
	}
	
	@GetMapping("/courses/{id}")
	public Course getCoursesById(@PathVariable int id) {
		return courseService.getCoursesById(id);
	}
	
	@PostMapping("/courses")
	public String createCourses(@RequestBody Course course) {
		return courseService.createCourses(course);
	}
	
	@PutMapping("/courses/{id}")
	public String updateExistingCourses(@PathVariable int id,@RequestBody Course course) {
		courseService.updateCourses(id, course);
		return "Updated Successfully";
	}
	
	@DeleteMapping("/courses/{id}")
	public String deleteCoursesById(@PathVariable int id) {
		
		return  courseService.deleteCoursesById(id);
	}
	
}
