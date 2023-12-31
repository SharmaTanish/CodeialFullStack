package com.codeial.codeial.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.codeial.codeial.entity.PostEntity;
import com.codeial.codeial.entity.UserEntity;
import com.codeial.codeial.repositories.PostRepository;
import com.codeial.codeial.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public List<PostEntity> getAllPosts() {
		return postRepository.findAll();
	}
	
	@Override
	public PostEntity savePost(String token, String content) {
		//get user from token---------------------------------------
		UserEntity user = null;
		
		PostEntity post = new PostEntity(user, content);// this new will auto-generate next Id
		// post.setContent(content);
		try {
			postRepository.saveAndFlush(post); //must put this in try/catch
			return post;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
