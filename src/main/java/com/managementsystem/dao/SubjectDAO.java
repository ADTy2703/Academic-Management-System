package com.managementsystem.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.managementsystem.entities.Subject;

@Repository
public class SubjectDAO {

	@Autowired
	private SessionFactory factory;
	
	public List<Subject> getAllSubjects() {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Subject.class);
		
		return criteria.list();
	}

	public Subject getSubjectsById(int id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Subject subject =session.get(Subject.class, id);
		
		return subject;
	}

	public String createSubjects(Subject subjects) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(subjects);
		
		return "Saved Successfully";
	}


	public void updateSubject(Subject subjects) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.update(subjects);
		
		tx.commit();
	}

	
	public String deleteSubjectsById(int id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Subject subject =session.get(Subject.class, id);
		
		session.delete(subject);
		tx.commit();
		return "Deleted Successfully";
	}
}
