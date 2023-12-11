package com.codeial.codeial.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codeial.codeial.entity.UserEntity;
import com.codeial.codeial.service.UserService;

@RestController
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserEntity userCredentails){
		List<UserEntity> users = userService.getAllUsers();
		for(UserEntity user : users) {
			if(user.getEmail().equals(userCredentails.getEmail()) && user.getPassword().equals(userCredentails.getPassword())) {
				return new ResponseEntity<String>("User logged in succesfully", HttpStatus.OK);
			}
		}
		return new ResponseEntity<String>("Invalid credentials", HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody UserEntity user){
		UserEntity newUser = new UserEntity(user.getUserName(), user.getEmail(), user.getPassword());// created this for ID
		HttpStatus status = userService.addUser(newUser);
		if(status==HttpStatus.OK) {
			return new ResponseEntity<String>("Signup successsfull", status);
		}
		return new ResponseEntity<String>("Something went wrong", status);
	}	
}
