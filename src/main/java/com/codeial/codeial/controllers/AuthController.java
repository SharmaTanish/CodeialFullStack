package com.codeial.codeial.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
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
    
    //@Autowired
    //private JwtHelper helper;
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody UserEntity userCredentails){
		System.out.println("In /login controller.");
		/*List<UserEntity> users = userService.getAllUsers();
		AuthResponse response;
		for(UserEntity user : users) {
			if(user.getEmail().equals(userCredentails.getEmail()) && user.getPassword().equals(userCredentails.getPassword())) {
				//generate token and send in response
				String token = this.helper.generateToken(user);
				response = new AuthResponse("User logged in successfully. Token:- " + token, true, user);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
		}
		response = new AuthResponse("Invalid credentials", false, null);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);*/
		AuthResponse response = new AuthResponse("Something went wrong", false, null);
		return new ResponseEntity<AuthResponse>(response, HttpStatus.OK);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<AuthResponse> signup(@RequestBody UserEntity user){
		System.out.println("In /signup controller.");
		/*UserEntity newUser = new UserEntity(user.getUsername(), user.getEmail(), user.getPassword());// created this for ID
		AuthResponse response;
		HttpStatus status = userService.addUser(newUser);	
		
		if(status==HttpStatus.OK) {
			//generate token and send in response
			String token = this.helper.generateToken(newUser);
			response = new AuthResponse("Signup successfull. JWT Token:- " + token, true, newUser);
			return new ResponseEntity<AuthResponse>(response, status);
		}*/
		AuthResponse response = new AuthResponse("Something went wrong", false, null);
		return new ResponseEntity<AuthResponse>(response, HttpStatus.OK);
	}	
	
}
