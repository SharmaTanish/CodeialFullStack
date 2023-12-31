package com.codeial.codeial.utilities;

import com.codeial.codeial.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthResponse {
	
	@JsonProperty
	private String message;
	
	@JsonProperty
	private Boolean success;

	@JsonProperty
	private AuthData<UserEntity> data;

	public AuthResponse(String message, Boolean success, UserEntity user) {
		super();
		this.message = message;
		this.success = success;
		this.data = new AuthData<>(user);
		if(user!=null) this.data.getUser().setPassword(null);
	}
}

@JsonInclude(JsonInclude.Include.NON_NULL)
class AuthData<T>{
	@JsonProperty
	private String token;
	@JsonProperty
	private T user;
	
	
	public AuthData(T user) {
		this(user, null);
	}

	public AuthData(T user, String token) {
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
	
}
