package com.taskbunny.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taskbunny.models.Tasks;
import com.taskbunny.service.TasksService;

@Controller
@ResponseBody
public class TasksController {

	@Autowired
	TasksService ts;
	
	@GetMapping("/tasks")
	public List<Tasks> findAllTask(){
		return ts.findAll();
	}
	
	@PostMapping("/tasks")
	public Tasks postTasks(@RequestBody Tasks tasks) {
		ts.saveTask(tasks);
		return tasks;
	}
	
}