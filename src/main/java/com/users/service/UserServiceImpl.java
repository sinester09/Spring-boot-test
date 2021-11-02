package com.users.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.users.model.Phone;
import com.users.model.PhoneRequest;
import com.users.model.User;
import com.users.model.UserRequest;
import com.users.repository.PhoneRepository;
import com.users.repository.UserRepository;
import com.users.security.JWTTokenGenerator;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;
	
	@Autowired
	PhoneRepository phoneRepository;
	
	@Autowired
	JWTTokenGenerator jwtGenerator;

	@Autowired
	BCryptPasswordEncoder enconder;

	@Override
	public Iterable<User> getAllUsers() {
		return repository.findAll();
	}

	@Override
	public Iterable<User> getAllActiveUsers() {
		return repository.findAllByIsActive(true);
	}

	@Override
	public User getUserFromRequest(UserRequest userRequest) {
		User user = new User();
		user.setId(UUID.randomUUID());
		user.setName(userRequest.getName());
		user.setEmail(userRequest.getEmail());
		user.setPassword(enconder.encode(userRequest.getPassword()));
		for (PhoneRequest phoneR : userRequest.getPhones()) {
			Phone phone = new Phone();
			phone.setId(UUID.randomUUID());
			phone.setNumber(phoneR.getNumber());
			phone.setCitycode(phoneR.getCitycode());
			phone.setCountrycode(phoneR.getCountrycode());
			user.getPhones().add(phone);
		}
		user.setCreted(new Date());
		user.setModified(new Date());
		user.setLastLogin(null);
		user.setToken(jwtGenerator.getJWTToken(user.getEmail()));
		user.setActive(true);

		return user;
	}

	@Override
	public boolean isEmailValid(String email) {
		boolean isValid = false;
		String emailPattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
		Pattern pattern = Pattern.compile(emailPattern);
		if (email != null) {
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches()) {
				isValid=true;
			}
		}
		return isValid;
	}

	@Override
	public boolean isPasswordValid(String password) {
		boolean isValid = false;
		String emailPattern = "^(?=.*[A-Z])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z].*[a-z].*[a-z]).{8}$";
		Pattern pattern = Pattern.compile(emailPattern);
		if (password != null) {
			Matcher matcher = pattern.matcher(password);
			if (matcher.matches()) {
				isValid=true;
			}
		}
		return isValid;
	}

	@Override
	public void saveUser(User user) {
		phoneRepository.saveAll(user.getPhones());
		repository.save(user);
	}

	@Override
	public User getUserById(UUID id) {
		return repository.findById(id).get();
	}

	@Override
	public boolean alreadyExistEmail(String email) {
		return ((ArrayList<User>) repository.findByEmail(email)).size() > 0;
	}

}
