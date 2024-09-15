package com.managementsystem.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.managementsystem.entities.Schedule;

@Repository
public class ScheduleDAO {

	@Autowired
	private SessionFactory factory;

	public List<Schedule> getAllClassSchedules() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Schedule.class);
		List<Schedule> list = criteria.list();
		return list;
	}

	public Schedule getSpecificClassSchedulesById(int id) {
		Session session = factory.openSession();
		Schedule schedule = session.get(Schedule.class, id);

		return schedule;
	}

	public String createNewClassSchedule(Schedule schedule) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(schedule);
		tx.commit();
		return "Saved Successfully";
	}

	public String updateClassSchedules(Schedule schedule) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.update(schedule);
	//	tx.commit();
		return "Update SUCCCESSFULLY";

	}

	public String deleteClassScheduleById(int id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Schedule sc = session.get(Schedule.class, id);
		session.delete(sc);

		tx.commit();
		return "Delete S U C C E S S F U L L Y";
	}

}
