package com.codeial.codeial.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long user_id;
	
	public UserEntity() {// this default constructor is necessary for entityManagerFactory
		super();
	}

	public UserEntity(String userName, String email, String password) {
		super();
		this.username = userName;
		this.email = email;
		this.password = password;
	}
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "email")
	private String email;
	
	
	private String password; // encrypt/decrypt later


	public String getEmail() {
		return email;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
