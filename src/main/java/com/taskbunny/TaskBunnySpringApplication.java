package com.taskbunny;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.taskbunny.repository.UsersRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UsersRepository.class)
public class TaskBunnySpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskBunnySpringApplication.class, args);
	}

}
