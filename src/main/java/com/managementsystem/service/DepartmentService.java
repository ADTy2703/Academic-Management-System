package com.managementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managementsystem.dao.DepartmentDAO;
import com.managementsystem.entities.Classroom;
import com.managementsystem.entities.Department;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentDAO departmentDAO;

	public List<Department> getAllDepartment() {

		return departmentDAO.getAllDepartment();
	}

	public Department getDepartmentById(int id) {

		return departmentDAO.getDepartmentById(id);
	}

	public String createDepartment(Department department) {

		return departmentDAO.createDepartment(department);
	}

	public Department updateDepartment(int id, Department department) {
		Department existingDepartment = departmentDAO.getDepartmentById(id);
		existingDepartment.setName(department.getName());

		departmentDAO.updateDepartments(existingDepartment);

		return existingDepartment;

	}

	public String deleteDepartmentById(int id) {

		return departmentDAO.deleteDepartmentById(id);
	}

}
