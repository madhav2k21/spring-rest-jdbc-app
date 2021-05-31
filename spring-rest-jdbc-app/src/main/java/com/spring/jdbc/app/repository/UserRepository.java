package com.spring.jdbc.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.jdbc.app.common.DBQueries;
import com.spring.jdbc.app.model.Users;

@Repository
public class UserRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public UserRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Users> findAll() {

		List<Users> users = jdbcTemplate.query(DBQueries.SELECT_ALL_USERS, new UserExtractor());
		// Instead of creating extractor class , we can use anonymous inner class or
		// java8 lambda expression here itself

		return users;
	}

	public Users findById(Integer id) {

		Object[] params = { id };
		Users users = jdbcTemplate.query(DBQueries.SELECT_USER_BY_ID, new UserExtractorById(), params);
		// Instead of creating extractor class , we can use anonymous inner class or
		// java8 lambda expression here itself

		return users;
	}

}
