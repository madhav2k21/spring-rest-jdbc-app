package com.spring.jdbc.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jdbc.app.model.Users;
import com.spring.jdbc.app.service.UserService;

@RestController
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	// http://localhost:8082/users/101
	@GetMapping(value = "/users/{id}")
	public Users findUserById(@PathVariable("id") Integer id) {
		Users user = userService.findUserById(id);
		return user;
	}

	// http://localhost:8082/users
	@GetMapping(value = "/users")
	public List<Users> findAllUsers() {
		List<Users> users = userService.findAllUsers();
		return users;
	}

	// Using ResponseEntity is the standard way to bind http methods in our controller

	// http://localhost:8082/users1/101
	@GetMapping(value = "/users1/{id}")
	public ResponseEntity<Users> findUserById1(@PathVariable("id") Integer id) {
		Users user = userService.findUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	// http://localhost:8082/users1
	@GetMapping(value = "/users1")
	public ResponseEntity<List<Users>> findAllUsers1() {
		List<Users> users = userService.findAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

}
