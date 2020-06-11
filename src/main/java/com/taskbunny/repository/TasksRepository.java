package com.taskbunny.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskbunny.models.Tasks;

public interface TasksRepository extends JpaRepository<Tasks, Integer>{

}
