package com.users.service;

import java.util.UUID;

import com.users.model.User;
import com.users.model.UserRequest;

public interface UserService {

	public Iterable<User> getAllUsers();
	
	public Iterable<User> getAllActiveUsers();
	
	public User getUserById(UUID id);
	
	public void saveUser(User user);
	
	public User getUserFromRequest(UserRequest userRequest);
	
	public boolean isEmailValid(String email);
	
	public boolean isPasswordValid(String password);
	
	public boolean alreadyExistEmail(String email);
}
