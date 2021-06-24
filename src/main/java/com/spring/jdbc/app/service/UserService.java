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
	
	
	public Users saveUser(Users user) {
		int count = userRepository.save(user);
		
		
		return count > 0 ? userRepository.findLatestUser() : new Users();
	}
	
	public String updateUserById(Users user, Integer id) {
		int count = userRepository.updaetById(user, id);
		//generally we send some status code to UI(angular/react) they will take of displaying status message
		//or we return the updated user entity
		return count > 0 ? "User is Updated successfully with Id: " + id : "Failed to Update the user";
	}
	
	public String deleteUserById(Integer id) {
		int count = userRepository.deleteById(id);
		//generally we send some status code to UI(angular/react) they will take of displaying status message
		return count > 0 ? "User is deleted successfully with Id: " + id : "Failed to Delete the user";
	}

}
