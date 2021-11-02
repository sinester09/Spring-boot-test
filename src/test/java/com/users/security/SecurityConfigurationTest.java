package com.users.security;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SecurityConfigurationTest {

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	void passwordEncoderExists() {
		assertThat(encoder).isNotNull();
	}

}
