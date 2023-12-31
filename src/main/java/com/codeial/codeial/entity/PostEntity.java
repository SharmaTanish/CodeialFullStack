package com.codeial.codeial.entity;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

@Entity
// @Getter
// @Setter
public class PostEntity {

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@jakarta.persistence.Id // to make primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // to auto-generate ID
	private long id;
	
	@Column(name="post_content", unique = true)
	private String content;
	
	private UserEntity user;

	public PostEntity(UserEntity user, String content) {
		super();
		this.content = content;
		this.user = user;
	}
}
