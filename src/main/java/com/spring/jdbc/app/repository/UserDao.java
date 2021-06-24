package com.spring.jdbc.app.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	public UserDao() {
		System.out.println("UserDao() 0 param constructor");
	}
	
	
	public void saveUser() {
		System.out.println("User is saved");
	}

	
	
}
