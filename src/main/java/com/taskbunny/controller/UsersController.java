package com.taskbunny.controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taskbunny.models.Tasks;
import com.taskbunny.models.Users;
import com.taskbunny.service.UsersService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsersController {
	
	@Autowired
	UsersService us;
	
	@GetMapping("/users")
	public List<Users> getAllUsers(){
		return us.findAll();		
	}
	
	@GetMapping("/usersbyrole")
	public Collection<Users> filter(){
		return us.filter();		
	}
	/*@PutMapping("/users"){
		
		
	}*/

	@GetMapping("/users/{id}")
	public Optional<Users> getOneUser(@PathVariable("id") int id){
		return us.getByUserID(id);
	}
	
	@GetMapping("/users/GetProvideName/{providerid}")
	public List<String> getProviderName(@PathVariable("providerid") int providerid){
		return us.getProviderName(providerid);
	}

	
	
	@PostMapping("/users")
	public Users postUsers(@RequestBody Users users) {
		us.saveUser(users);
		return users;
	}
	
	@PutMapping("/user/{id}")
	public void updatePicture(@PathVariable("id") int id,@RequestBody Users user){
		
		 us.setPicture(id,user.getPicture());
		
	}
	
}
