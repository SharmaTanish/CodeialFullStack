package com.codeial.codeial.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	public UserDetails loadUserByUsername(String username) {
		System.out.println("in load user");
		List<UserEntity> users = userRepository.findAll();
		UserEntity user = null;
		for(UserEntity u : users) {
			System.out.println(u.getUsername());
			if(u.getUsername().equals(username)) {
				user = u;
			}
		}
        if (user == null) {
            throw new UsernameNotFoundException("User Not found");
        }
        return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
