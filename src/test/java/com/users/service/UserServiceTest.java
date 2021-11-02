package com.users.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.users.model.Phone;
import com.users.model.PhoneRequest;
import com.users.model.User;
import com.users.model.UserRequest;

@SpringBootTest
class UserServiceTest {

	@Autowired
	UserService userService;
	
	@Test
	void contextLoadTest() {
		assertThat(userService).isNotNull();
	}
	
	@Test
	void getAllUsersTest() {
		assertThat(userService.getAllUsers()).isNotNull();
	}

	@Test
	void getAllActiveUsersTest() {
		assertThat(userService.getAllActiveUsers()).isNotNull();
	}
	
	@Test
	void getUserFromRequestTest() {
		
		UserRequest userReq = new UserRequest();
		userReq.setName("User Name");
		userReq.setEmail("aaa@dominio.com");
		userReq.setPassword("Abcde12");
		PhoneRequest phone = new PhoneRequest();
		phone.setNumber("123456789");
		phone.setCitycode("1");
		phone.setCountrycode("56");
		List<PhoneRequest> phones = new ArrayList<PhoneRequest>();
		phones.add(phone);
		userReq.setPhones(phones);
		
		User user = userService.getUserFromRequest(userReq);
		
		assertEquals(userReq.getEmail(), user.getEmail());
		
	}
	
	void isEmailValidTest() {
		String validEmail = "aaaa@dominio.com";
		assertEquals(true, userService.isEmailValid(validEmail));
	}
	
	void isEmailNotValidTest() {
		String notValidEmail = "aaaadominio.com";
		assertEquals(false, userService.isEmailValid(notValidEmail));
	}
	
	void isPasswordlValidTest() {
		String validPassword = "Abcdef12";
		assertEquals(true, userService.isPasswordValid(validPassword));
	}
	
	void isPasswordNotValidTest() {
		String notValidPassword = "12345678";
		assertEquals(false, userService.isPasswordValid(notValidPassword));
	}
}
