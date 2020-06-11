package com.taskbunny.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskbunny.models.Tasks;
import com.taskbunny.repository.TasksRepository;

@Service
public class TasksService {
	
	@Autowired
	TasksRepository tr;
	
	public void saveTask(Tasks t) {
		tr.save(t);
	}
	
	public List<Tasks> findAll(){
		return tr.findAll();
	}
	
}