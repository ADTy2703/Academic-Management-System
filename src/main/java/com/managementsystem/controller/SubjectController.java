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

import com.managementsystem.dao.SubjectDAO;
import com.managementsystem.entities.Subject;
import com.managementsystem.service.SubjectService;

@RestController
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;

	@GetMapping("/subjects")
	public List<Subject> getAllSubjects() {
		return subjectService.getAllSubjects();
	}

	@GetMapping("/subjects/{id}")
	public Subject getSubjectsById(@PathVariable int id) {
		return subjectService.getSubjectsById(id);
	}

	@PostMapping("/subjects")
	public String createSubjects(@RequestBody Subject subjects) {
		return subjectService.createSubjects(subjects);
	}

	@PutMapping("/subjects/{id}")
	public String updateExistingSubjects(@PathVariable int id, @RequestBody Subject subjects) {
		subjectService.updateSubjects(id, subjects);
		return "Updated Successfully";
	}

	@DeleteMapping("/subjects/{id}")
	public String deleteSubjectsById(@PathVariable int id) {

		return subjectService.deleteSubjectsById(id);
	}

}
