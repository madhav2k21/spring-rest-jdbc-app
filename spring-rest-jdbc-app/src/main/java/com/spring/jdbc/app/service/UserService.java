package com.spring.jdbc.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.jdbc.app.model.Users;
import com.spring.jdbc.app.repository.UserRepository;

@Service
public class UserService {
	
	
	private UserRepository userRepository;
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<Users> findAllUsers() {
		List<Users> users = userRepository.findAll();
		return users;
	}
	public Users findUserById(Integer id) {
		Users user = userRepository.findById(id);
		return user;
	}

}
