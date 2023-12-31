package com.codeial.codeial.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.codeial.codeial.entity.UserEntity;
import com.codeial.codeial.repositories.UserRepository;
import com.codeial.codeial.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public HttpStatus addUser(UserEntity user) {
		try {
			userRepository.saveAndFlush(user);
		}
		catch(Exception e) {
			e.printStackTrace();
			return HttpStatus.BAD_REQUEST;
		}
		return HttpStatus.OK;
	}

	@Override
	public UserEntity loadUserByUsername(String username) {
		List<UserEntity> users = userRepository.findAll();
		for(UserEntity user : users) {
			if(user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}
	
}
