package com.taskbunny.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users implements Serializable{
	
	@Id
	@GeneratedValue
	private int userid;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "datejoined")
	private Date datejoined;
	
	@Lob
	@Column(name = "picture")
	private byte[] picture;
	
	public Users() {}

	public Users(String username, String password, String role, String firstname, String lastname,
			Date datejoined, byte[] picture) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.firstname = firstname;
		this.lastname = lastname;
		this.datejoined = datejoined;
		this.picture = picture;
	}


	public Users(int userid, String username, String password, String role, String firstname, String lastname,
			Date datejoined, byte[] picture) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.role = role;
		this.firstname = firstname;
		this.lastname = lastname;
		this.datejoined = datejoined;
		this.picture = picture;
	}




	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDatejoined() {
		return datejoined;
	}

	public void setDatejoined(Date datejoined) {
		this.datejoined = datejoined;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	
	
}
