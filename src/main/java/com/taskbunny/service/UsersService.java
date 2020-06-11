package com.taskbunny.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskbunny.repository.UsersRepository;
import com.taskbunny.models.Users;

@Service
public class UsersService {
	
	@Autowired
	UsersRepository ur;
	
	public void saveUser(Users users) {
		ur.save(users);
	}
	
	public List<Users> findAll(){
		return ur.findAll();
	}
	
}
