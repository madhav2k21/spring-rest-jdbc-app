package com.spring.jdbc.app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.jdbc.app.model.Users;
import com.spring.jdbc.app.repository.UserRepository;
import com.spring.jdbc.app.service.UserService;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

	private UserController userController;
	private MockMvc mockMvc;

	@Autowired
	public void setUserController(UserController userController) {
		this.userController = userController;
	}

	@Autowired
	public void setMockMvc(MockMvc mockMvc) {
		this.mockMvc = mockMvc;
	}

	@MockBean
	private UserService userService;
	@MockBean
	private UserRepository userRepository;

	@Test
	void testSaveUser() {
		final String EXPECTED_RESULT = "User is saved successfully";
		Users user = new Users(109, "madhav", "HYD");
		when(userRepository.save(user)).thenReturn(1);

		when(userService.saveUser(user)).thenReturn(EXPECTED_RESULT);
		String saveUser = userController.saveUser(user);
		assertEquals(EXPECTED_RESULT, saveUser);
	}

	@Test
	public void testControllerSaveUser() throws Exception {
		final String EXPECTED_RESULT = "User is saved successfully";
		Users user = new Users(109, "madhav", "HYD");
		ObjectMapper mapper = new ObjectMapper();
		String jsonRequest = mapper.writeValueAsString(user);

		when(userRepository.save(user)).thenReturn(1);
		when(userService.saveUser(user)).thenReturn(EXPECTED_RESULT);
		this.mockMvc.perform(post("/users").content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	public void testFindUserById() throws Exception {
		Users user = new Users(109, "madhav", "HYD");
		
		when(userRepository.findById(109)).thenReturn(user);
		when(userService.findUserById(109)).thenReturn(user);
		
		
		this.mockMvc.perform(get("/users/109")).andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id").value(109))
		.andExpect(jsonPath("$.name").value("madhav"))
		.andExpect(jsonPath("$.location").value("HYD"));

	}

	@Test
	public void testFindAllUsers() throws Exception {
		Users u1 = new Users(109, "madhav", "HYD");
		Users u2 = new Users(110, "dill", "PA");
		List<Users> users = new ArrayList<>();
		users.add(u1);
		users.add(u2);

		when(userService.findAllUsers()).thenReturn(users);
		
		this.mockMvc.perform(get("/users")).andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.[1].name").value("dill"))
		.andExpect(jsonPath("$.length()",is(2)));

	}

}
