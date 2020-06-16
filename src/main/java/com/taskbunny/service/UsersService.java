package com.taskbunny.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskbunny.repository.UsersRepository;
import com.taskbunny.models.Users;

@Service
public class UsersService{
	
	@Autowired
	UsersRepository ur;
	
	public Collection<Users> filter(){
		return ur.findAllActiveUsersNative();
	}
	

	
	public void saveUser(Users users) {
		ur.save(users);

	}
	
	public List<Users> findAll(){
		return ur.findAll();
	}
	
	public Optional<Users> getByUserID(int id) {
		return ur.findById(id);
	}



	public void setPicture(int id, byte[] picture) {
		
		ur.updatePicture(id,picture);
		
	}



	public List<String> getProviderName(int providerid) {
		// TODO Auto-generated method stub
		return ur.getProviderName(providerid);
	}



	public String getUserRoleByProviderID(int providerid) {
		// TODO Auto-generated method stub
		return ur.getUserRoleByProviderID(providerid);
	}



	public int getProviderIDByUserName(String username) {
		// TODO Auto-generated method stub
		return ur.getProviderIDByUserName(username);
	}



	
	
	
}
