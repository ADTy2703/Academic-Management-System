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

import com.managementsystem.dao.ClassroomDAO;
import com.managementsystem.entities.Classroom;
import com.managementsystem.service.ClassroomService;

@RestController
public class ClassroomController {
	
	@Autowired
	private ClassroomService classService;
	
	@GetMapping("/classrooms")
	public List<Classroom> getAllClassrooms() {
		return classService.getAllClassrooms();
	}
	
	@GetMapping("/classrooms/{id}")
	public Classroom getClassroomById(@PathVariable int id) {
		return classService.getClassroomById(id);
	}
	
	@PostMapping("/classrooms")
	public String createClassroom(@RequestBody Classroom classroom) {
		return classService.createClassroom(classroom);
	}
	
	@PutMapping("/classrooms/{id}")
	public String updateExistingClassroom(@PathVariable int id,@RequestBody Classroom classroom) {
		classService.updateClassroom(id, classroom);
		return "Updated Successfully";
	}
	
	@DeleteMapping("/classrooms/{id}")
	public String deleteClassroomById(@PathVariable int id) {
		
		return  classService.deleteClassroomById(id);
	}
}
