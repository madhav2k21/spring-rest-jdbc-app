package com.spring.jdbc.app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.spring.jdbc.app.model.Users;
import com.spring.jdbc.app.repository.UserRepository;
import com.spring.jdbc.app.service.UserService;

@SpringBootTest
class UserControllerTest {
	@Autowired
	private UserController userController;
	@MockBean
	private UserService userService;
	@MockBean
	private UserRepository userRepository;

	@Test
	void saveUser() {
		Users user = new Users(109, "madhav", "HYD");
		when(userRepository.save(user)).thenReturn(1);

		when(userService.saveUser(user)).thenReturn("User is saved successfully");
		String saveUser = userController.saveUser(user);
		assertEquals("User is saved successfully", saveUser);
	}

}
