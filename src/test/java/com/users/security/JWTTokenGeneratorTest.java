package com.users.security;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JWTTokenGeneratorTest {

	@Autowired
	private JWTTokenGenerator tokenGenerator;
	
	@Test
	void tokenGeneratorExistsTest() {
		assertThat(tokenGenerator).isNotNull();
	}
	
	@Test
	void getJWTTokenTest() {
		String token = tokenGenerator.getJWTToken("username");
		assertThat(token).isNotNull();
	}

}
