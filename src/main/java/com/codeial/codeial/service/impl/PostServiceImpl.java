package com.codeial.codeial.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.codeial.codeial.entity.PostEntity;
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
	public HttpStatus savePost(String content) {
		PostEntity post = new PostEntity();// this new will auto-generate next Id
		post.setContent(content);
		try {
			postRepository.saveAndFlush(post); //must put this in try/catch
			return HttpStatus.OK;
		} catch (Exception e) {
			e.printStackTrace();
			return HttpStatus.BAD_REQUEST;
		}
		
	}
}
