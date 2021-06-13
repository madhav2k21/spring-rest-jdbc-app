package com.spring.jdbc.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.jdbc.app.repository.UserDao;

@Service
public class UsrService {

	private UserDao userDao;

	
	@Autowired
	public void setUserDao(UserDao userDao) {
		System.out.println("Setter method injection");
		this.userDao = userDao;
	}
	@Autowired
	public UsrService(UserDao userDao) {
		System.out.println("UsrService(UserDao userDao) 1 param constructor");
		this.userDao = userDao;
	}
	
	public void saveUser() {
		userDao.saveUser();
	}
}
