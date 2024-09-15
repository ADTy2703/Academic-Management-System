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

import com.managementsystem.dao.FacultyDAO;
import com.managementsystem.entities.Faculty;
import com.managementsystem.service.FacultyService;

@RestController
public class FacultyController {
		
	@Autowired
	private FacultyService facultyService;
	
	@GetMapping("/faculties")
	public List<Faculty> getAllFaculty() {
		
		return facultyService.getAllFaculty();
	}
	
	@GetMapping("/faculties/{id}")
	public Faculty getFacultyById(@PathVariable int id) {
		return facultyService.getFacultyById(id);
	}
	
	@PostMapping("/faculties")
	public String createFaculty(@RequestBody Faculty faculty) {
		return facultyService.createFaculty(faculty);
	}
	
	@PutMapping("/faculties/{id}")
	public String updateExistingFaculty(@PathVariable int id,@RequestBody Faculty faculty) {
		facultyService.updateFaculty(id, faculty);
		return "Updated Successfully";
	}
	
	@DeleteMapping("/faculties/{id}")
	public String deleteFacultyById(@PathVariable int id) {
		
		return  facultyService.deleteFacultyById(id);
	}
	
}
