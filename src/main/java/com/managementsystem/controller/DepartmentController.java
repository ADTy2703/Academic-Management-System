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

import com.managementsystem.dao.DepartmentDAO;
import com.managementsystem.entities.Classroom;
import com.managementsystem.entities.Course;
import com.managementsystem.entities.Department;
import com.managementsystem.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/departments")
	public List<Department> getAllDepartment() {
		return departmentService.getAllDepartment();
	}

	@GetMapping("/departments/{id}")
	public Department getDepartmentById(@PathVariable int id) {
		return departmentService.getDepartmentById(id);
	}

	@PostMapping("/departments")
	public String createDepartment(@RequestBody Department department) {
		return departmentService.createDepartment(department);
	}

	@PutMapping("/departments/{id}")
	public String updateExistingDepartment(@PathVariable int id, @RequestBody Department department) {
		departmentService.updateDepartment(id, department);
		return "Updated Successfully";
	}

	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable int id) {
		return departmentService.deleteDepartmentById(id);
	}

}
