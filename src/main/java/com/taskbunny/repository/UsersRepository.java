package com.taskbunny.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskbunny.models.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	Optional<Users> findByUserName(String userName);
}
