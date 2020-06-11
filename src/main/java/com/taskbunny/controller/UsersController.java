package com.taskbunny.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taskbunny.models.Users;
import com.taskbunny.service.UsersService;


@Controller
@ResponseBody
@CrossOrigin(origins = "", allowedHeaders = "")
public class UsersController {
	
	@Autowired
	UsersService us;
	
	@GetMapping("/users")
	public List<Users> getAllUsers(){
		return us.findAll();		
	}
	
	@PostMapping("/users")
	public Users postUsers(@RequestBody Users users) {
		us.saveUser(users);
		return users;
	}
}
