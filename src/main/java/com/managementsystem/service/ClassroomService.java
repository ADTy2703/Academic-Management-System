package com.managementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managementsystem.dao.ClassroomDAO;
import com.managementsystem.entities.Classroom;

@Service
public class ClassroomService { 

	@Autowired
	private ClassroomDAO classroomDao;
	
	public List<Classroom> getAllClassrooms() {
		// TODO Auto-generated method stub
		return classroomDao.getAllClassrooms();
	}

	public Classroom getClassroomById(int id) {
		// TODO Auto-generated method stub
		return classroomDao.getClassroomById(id);
	}

	public String createClassroom(Classroom classroom) {
		// TODO Auto-generated method stub
		return classroomDao.createClassroom(classroom);
	}

	public Classroom updateClassroom(int id , Classroom classroom) {
		Classroom existingClassroom = classroomDao.getClassroomById(id);
		 existingClassroom.setName(classroom.getName());
		 classroomDao.updateClassroom(existingClassroom);
		 
		 return existingClassroom;
	}
	
	public String deleteClassroomById(int id) {
		// TODO Auto-generated method stub
		return classroomDao.deleteClassroomById(id);
	}
	

}
