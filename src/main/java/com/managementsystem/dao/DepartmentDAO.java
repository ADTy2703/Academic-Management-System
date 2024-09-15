package com.managementsystem.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.managementsystem.entities.Department;

@Repository
public class DepartmentDAO {

	@Autowired
	private SessionFactory factory;
	
	public List<Department> getAllDepartment() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Department.class);
		List<Department> list= criteria.list();
		return list;
	}

	public Department getDepartmentById(int id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Department department = session.get(Department.class, id);

		return department;
	}

	public String createDepartment(Department department) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(department);

		tx.commit();
		session.close();
		return "Saved Successfully";
	}

	public void updateDepartments(Department department) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
        session.update(department);
		tx.commit();
	}
	
	public String deleteDepartmentById(int id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Department department = session.get(Department.class, id);
		session.delete(department);
		tx.commit();
		
		return "Deleted Successfully";
	}


}
