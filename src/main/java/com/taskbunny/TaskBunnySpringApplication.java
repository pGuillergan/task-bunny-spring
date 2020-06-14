package com.taskbunny;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.taskbunny.controller.TasksController;

@SpringBootApplication
public class TaskBunnySpringApplication {
	
	public static void main(String[] args) {

		SpringApplication.run(TaskBunnySpringApplication.class, args);
	}

}
