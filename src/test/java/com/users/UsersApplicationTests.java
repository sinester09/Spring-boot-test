package com.users;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.users.api.UserApi;

@SpringBootTest
class UsersApplicationTests {

	@Autowired
	private UserApi userApi;
	
	@Test
	void contextLoads() {
		assertThat(userApi).isNotNull();
	}

}
