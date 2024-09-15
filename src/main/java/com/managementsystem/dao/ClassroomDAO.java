package com.managementsystem.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.managementsystem.entities.Classroom;

@Repository
public class ClassroomDAO {

	@Autowired
	private SessionFactory factory;

	public List<Classroom> getAllClassrooms() {

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(Classroom.class);
		List<Classroom> list = criteria.list();

		return list;
	}

	public Classroom getClassroomById(int id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Classroom classroom = session.get(Classroom.class, id);

		return classroom;
	}

	public String createClassroom(Classroom classroom) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(classroom);

		tx.commit();
		session.close();
		return "Saved Successfully";
	}

	public void updateClassroom(Classroom classroom) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
        session.update(classroom);
		tx.commit();
	}

	public String deleteClassroomById(Integer id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Classroom class1 = session.get(Classroom.class, id);
		session.delete(class1);
		tx.commit();
		
		return "Deleted Successfully";
	}
	

}
