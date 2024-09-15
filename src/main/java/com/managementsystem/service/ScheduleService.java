package com.managementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managementsystem.dao.ScheduleDAO;
import com.managementsystem.entities.Classroom;
import com.managementsystem.entities.Schedule;

@Service
public class ScheduleService {

	@Autowired
	private ScheduleDAO scheduleDAO;

	public String updateClassSchedules(int id, Schedule schedule) {
		Schedule existingSchedule = scheduleDAO.getSpecificClassSchedulesById(id);

		existingSchedule.setClassroom(schedule.getClassroom());
		existingSchedule.setStartTime(schedule.getStartTime());
		existingSchedule.setEndTime(schedule.getEndTime());
		existingSchedule.setDayOfWeek(schedule.getDayOfWeek());
		existingSchedule.setSubject(schedule.getSubject());

		return scheduleDAO.updateClassSchedules(existingSchedule);
	}

	public List<Schedule> getAllClassSchedules() {
		// TODO Auto-generated method stub
		return scheduleDAO.getAllClassSchedules();
	}

	public Schedule getSpecificClassSchedulesById(int id) {
		// TODO Auto-generated method stub
		return scheduleDAO.getSpecificClassSchedulesById(id);
	}

	public String createNewClassSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		return scheduleDAO.createNewClassSchedule(schedule);
	}

	public String deleteClassScheduleById(int id) {
		// TODO Auto-generated method stub
		return scheduleDAO.deleteClassScheduleById(id);
	}

}
