package com.codeial.codeial.utilities;

import com.codeial.codeial.entity.PostEntity;
import com.codeial.codeial.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SavePostResponse {
	/*
	@JsonProperty
	private String message;
	
	@JsonProperty
	private Boolean success;

	@JsonProperty
	private AuthData<PostEntity> data;

	public SavePostResponse(String message, Boolean success, PostEntity post) {
		super();
		this.message = message;
		this.success = success;
		this.data = new Data<>(post);
		if(post!=null) this.data.getUser().setPassword(null);
	}
}

@JsonInclude(JsonInclude.Include.NON_NULL)
class Data<T>{
	@JsonProperty
	private String token;
	@JsonProperty
	private T user;
	
	public Data(T user) {
		this(user, null);
	}

	public Data(T user, String token) {
		super();
		this.token = token;
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public T getUser() {
		return user;
	}

	public void setUser(T user) {
		this.user = user;
	}
	*/
}
