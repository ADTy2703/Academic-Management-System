package com.managementsystem.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.managementsystem.entities.Course;

@Repository
public class CourseDAO {

	@Autowired
	private SessionFactory factory;

	public List<Course> getAllCourses() {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(Course.class);
		List<Course> list = criteria.list();

		return list;
	}

	public Course getCoursesById(int id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Course course = session.get(Course.class, id);

		return course;
	}

	public String createCourses(Course course) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(course);

		tx.commit();
		session.close();
		return "Saved Successfully";
	}

	public String deleteCoursesById(int id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Course course = session.get(Course.class, id);
		session.delete(course);
		tx.commit();
		
		return "Deleted Successfully";
	}

	public void updateCourses( Course course) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
        session.update(course);
		tx.commit();
	}
}
