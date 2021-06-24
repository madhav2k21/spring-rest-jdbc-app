package com.spring.jdbc.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jdbc.app.model.Users;
import com.spring.jdbc.app.service.UserService;

@RestController
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	// http://localhost:8082/users/101
	@GetMapping(value = "/users/{id}")
	public Users findUserById(@PathVariable("id") Integer id) {
		logger.info("Inside findUserById in UserController");
		Users user = userService.findUserById(id);
		logger.info("Exiting from findUserById in UserController");
		return user;
	}

	// http://localhost:8082/users
	@GetMapping(value = "/users")
	public List<Users> findAllUsers() {
		logger.info("Inside findAllUsers in UserController");
		List<Users> users = userService.findAllUsers();
		logger.info("Exiting from findAllUsers in UserController");
		return users;
	}
	
//****************Sample request body to save User resource Start
	/*
	 * id will be auto generated
	 * http POST request
	 * http://localhost:8082/users 
	 {
  		"name": "TestUser",
  		"location": "Hyderabad"
	 }
	
	 */
	
	@PostMapping(value = "/users")
	public @ResponseBody Users saveUser(@RequestBody Users user) {
		logger.info("Inside saveUser in UserController");
		 user = userService.saveUser(user);
		logger.info("Exiting from saveUser in UserController");
		return user;
	}
	//****************Sample request body to save User resource End
	
	// http://localhost:8082/users/101
	@DeleteMapping(value = "/users/{id}")
	public String deleteUserById(@PathVariable("id") Integer id) {
		logger.info("Inside deleteUserById in UserController");
		String result = userService.deleteUserById(id);
		logger.info("Exiting from deleteUserById in UserController");
		return result;
	}
	
	/*
	 * http PUT request
	 * http://localhost:8082/users/108 
	 {
  		"name": "TestUser1",
  		"location": "New York"
	 }
	
	 */
	@PutMapping(value = "/users/{id}")
	public String updateUserById(@RequestBody Users user, @PathVariable("id") Integer id) {
		logger.info("Inside updateUserById in UserController");
		String result = userService.updateUserById(user, id);
		logger.info("Exiting from updateUserById in UserController");
		return result;
	}
	
	
	
	// Using ResponseEntity is the recommended standard way to bind http methods in
	// our controller

	// http://localhost:8082/users1/101
	@GetMapping(value = "/users1/{id}")
	public ResponseEntity<Users> findUserById1(@PathVariable("id") Integer id) {
		logger.info("Inside findUserById1 in UserController");
		Users user = userService.findUserById(id);
		logger.info("Exiting from findUserById1 in UserController");
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	// http://localhost:8082/users1
	@GetMapping(value = "/users1")
	public ResponseEntity<List<Users>> findAllUsers1() {
		logger.info("Inside findAllUsers1 in UserController");
		List<Users> users = userService.findAllUsers();
		logger.info("Exiting from findAllUsers1 in UserController");
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PostMapping(value = "/users1")
	public ResponseEntity<Users> saveUser1(@RequestBody Users user) {
		logger.info("Inside saveUser1 in UserController");
		user = userService.saveUser(user);
		logger.info("Exiting from saveUser1 in UserController");
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/users/{id}")
	public ResponseEntity<String> updateUserById1(@RequestBody Users user, @PathVariable("id") Integer id) {
		logger.info("Inside updateUserById in UserController");
		String result = userService.updateUserById(user, id);
		logger.info("Exiting from updateUserById in UserController");
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
