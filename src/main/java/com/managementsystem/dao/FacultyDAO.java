package com.managementsystem.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.managementsystem.entities.Faculty;

@Repository
public class FacultyDAO {

	@Autowired
	private SessionFactory factory;
	
	public List<Faculty> getAllFaculty() {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Faculty.class);
		
		return criteria.list();
	}

	public Faculty getFacultyById(int id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Faculty faculty = session.get(Faculty.class, id);
		
		return faculty;
	}

	public void createFaculty(Faculty faculty) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(faculty);
		tx.commit();
		
	}

	public void updateFaculties(Faculty faculty) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.saveOrUpdate(faculty);
		
        tx.commit();
		
	}
	
	public void deleteFacultyById(int id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Faculty faculty = session.get(Faculty.class, id);
		
		session.delete(faculty);
		tx.commit();
	}

	

}
