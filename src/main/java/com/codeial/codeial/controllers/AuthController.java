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
import com.codeial.codeial.utilities.AuthResponse;

@RestController
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody UserEntity userCredentails){
		List<UserEntity> users = userService.getAllUsers();
		AuthResponse response;
		for(UserEntity user : users) {
			if(user.getEmail().equals(userCredentails.getEmail()) && user.getPassword().equals(userCredentails.getPassword())) {
				response = new AuthResponse("User logged in successfully", true, user);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
		}
		response = new AuthResponse("Invalid credentials", false, null);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<AuthResponse> signup(@RequestBody UserEntity user){
		UserEntity newUser = new UserEntity(user.getUsername(), user.getEmail(), user.getPassword());// created this for ID
		AuthResponse response;
		HttpStatus status = userService.addUser(newUser);	
		if(status==HttpStatus.OK) {
			response = new AuthResponse("Signup successfull", true, newUser);
			return new ResponseEntity<AuthResponse>(response, status);
		}
		response = new AuthResponse("Something went wrong", false, null);
		return new ResponseEntity<AuthResponse>(response, status);
	}	
}
