package com.managementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managementsystem.dao.SubjectDAO;
import com.managementsystem.entities.Subject;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectDAO subjectDAO;

	public String updateSubjects(int id, Subject subjects) {
		Subject existingSubject = subjectDAO.getSubjectsById(id);
		existingSubject.setId(subjects.getId());
		existingSubject.setCourseId(subjects.getCourseId());
		existingSubject.setName(subjects.getName());
		
		subjectDAO.updateSubject(existingSubject);
		
		return "Updated Successfully";
	}

	public List<Subject> getAllSubjects() {

		return subjectDAO.getAllSubjects();
	}

	public Subject getSubjectsById(int id) {

		return subjectDAO.getSubjectsById(id);
	}

	public String createSubjects(Subject subjects) {

		return subjectDAO.createSubjects(subjects);
	}

	public String deleteSubjectsById(int id) {

		return subjectDAO.deleteSubjectsById(id);
	}

}
