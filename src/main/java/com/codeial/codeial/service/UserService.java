package com.codeial.codeial.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.codeial.codeial.entity.UserEntity;

@Service
public interface UserService {
	
	public List<UserEntity> getAllUsers();
	
	public HttpStatus addUser(UserEntity user);
	
	public UserEntity loadUserByUsername(String username);
	//write methods...
}
