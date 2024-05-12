package com.codeial.codeial.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codeial.codeial.entity.PostEntity;

import com.codeial.codeial.service.PostService;
import com.codeial.codeial.utilities.SavePostResponse;

@RestController
public class PostController {
	@Autowired
	PostService postService;
	
	@GetMapping("/posts")
	public ResponseEntity<List<PostEntity>> getPosts(){
		// jwtHelper.validateToken(jwtToken, userCredentails); --> already done on JwtAuthenticationFilter in DTO?
		
		List<PostEntity> posts = postService.getAllPosts();
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
	/*
	@PostMapping("/posts")
	public ResponseEntity<SavePostResponse> savePosts(@RequestParam String token, @RequestBody String content){
		PostEntity post = postService.savePost(token, content);
		if(post!=null) return new ResponseEntity<>(new SavePostResponse("Post added successfully", true, post), HttpStatus.OK);
		return new ResponseEntity<>(new SavePostResponse("Some error occured", false, null), HttpStatus.BAD_REQUEST);
	}
	*/
}
