package com.users.security;

public interface JWTTokenGenerator {

	public String getJWTToken(String username);
}
