package com.managementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.managementsystem.dao.ScheduleDAO;
import com.managementsystem.entities.Schedule;
import com.managementsystem.service.ScheduleService;

@RestController
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;

	@GetMapping("/classSchedules")
	public List<Schedule> getAllClassSchedules() {
		return scheduleService.getAllClassSchedules();
	}

	@GetMapping("/classSchedules/{id}")
	public Schedule getSpecificClassSchedulesById(@PathVariable int id) {
		return scheduleService.getSpecificClassSchedulesById(id);
	}

	@PostMapping("/classSchedules")
	public String createNewClassSchedule(@RequestBody Schedule schedule) {

		return scheduleService.createNewClassSchedule(schedule);
	}
	
	@PutMapping("/classSchedules/{id}")
	public String updateClassSchedules(@PathVariable int id,@RequestBody Schedule schedule) {
		return scheduleService.updateClassSchedules(id,schedule);
	}
	
	@DeleteMapping("/classSchedules/{id}")
	public String deleteClassScheduleById(@PathVariable int id) {
		return scheduleService.deleteClassScheduleById(id);
	}
}
