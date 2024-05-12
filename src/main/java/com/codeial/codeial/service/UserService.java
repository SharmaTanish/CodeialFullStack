package com.codeial.codeial.service;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codeial.codeial.entity.UserEntity;

@Service
public interface UserService extends UserDetailsService{
	
	public List<UserEntity> getAllUsers();
	
	public HttpStatus addUser(UserEntity user);
	
	@Override
	public UserDetails loadUserByUsername(String username);
	//write methods...
	
	@Bean
    public PasswordEncoder passwordEncoder();
}
