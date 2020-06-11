package com.taskbunny.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskbunny.models.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

}
