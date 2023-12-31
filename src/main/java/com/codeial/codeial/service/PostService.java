package com.codeial.codeial.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.codeial.codeial.entity.PostEntity;

@Service
public interface PostService {
	List<PostEntity> getAllPosts();
	
	PostEntity savePost(String token, String content);
}
