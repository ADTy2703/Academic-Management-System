package com.managementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managementsystem.dao.FacultyDAO;
import com.managementsystem.entities.Classroom;
import com.managementsystem.entities.Faculty;

@Service
public class FacultyService {

	@Autowired
	private FacultyDAO facultyDAO;

	public List<Faculty> getAllFaculty() {

		return facultyDAO.getAllFaculty();
	}

	public Faculty getFacultyById(int id) {

		return facultyDAO.getFacultyById(id);
	}

	public String createFaculty(Faculty faculty) {
		facultyDAO.createFaculty(faculty);
		return "Saved ";
	}

	public Faculty updateFaculty(int id, Faculty faculty) {
		Faculty existingFaculty = facultyDAO.getFacultyById(id);

		existingFaculty.setName(faculty.getName());
		existingFaculty.setEmail(faculty.getEmail());
		existingFaculty.setDepartmentId(faculty.getDepartmentId());

		facultyDAO.updateFaculties(existingFaculty);

		return existingFaculty;

	}

	public String deleteFacultyById(int id) {
		facultyDAO.deleteFacultyById(id);
		return "Deleted Successfully";
	}

}
