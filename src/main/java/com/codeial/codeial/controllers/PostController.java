package com.codeial.codeial.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codeial.codeial.entity.PostEntity;

import com.codeial.codeial.service.PostService;

@RestController
public class PostController {
	@Autowired
	PostService postService;
	
	@GetMapping("/posts")
	public ResponseEntity<List<PostEntity>> getPosts(){
		List<PostEntity> posts = postService.getAllPosts();
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
	
	@PostMapping("/posts")
	public ResponseEntity<String> savePosts(@RequestParam String content){
		HttpStatus status = postService.savePost(content);
		return new ResponseEntity<>(status==HttpStatus.OK ? "Post saved!" : "Some error occured!", status);
	}
}
