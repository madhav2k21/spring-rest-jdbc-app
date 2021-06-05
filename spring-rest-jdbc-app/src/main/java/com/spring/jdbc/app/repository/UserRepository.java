package com.spring.jdbc.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
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

		//Approach-1: Using Custom extractor class: start
		/*
		List<Users> users = jdbcTemplate.query(DBQueries.SELECT_ALL_USERS, new UserExtractor());
		*/
		//Approach-1: Using Custom extractor class: End
		
		//Approach-2: Using anonymous inner class start
		/*
		List<Users> users = new ArrayList<>();
		Object[] params = {};
		jdbcTemplate.query(DBQueries.SELECT_ALL_USERS, new ResultSetExtractor<List<Users>>() {

			@Override
			public List<Users> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while (rs.next()) {
					Users user = new Users();
					user.setId(rs.getInt("ID"));
					user.setName(rs.getString("NAME"));
					user.setLocation(rs.getString("LOCATION"));
					users.add(user);
				}

				return users;
			}
		}, params);
		*/
		//Approach-2: Using anonymous inner class end

		//Approach-3: Using java8 Lambda expression start (recommended approach)
		
		List<Users> users = new ArrayList<>();
		
		Object[] params = {};

		jdbcTemplate.query(DBQueries.SELECT_ALL_USERS, (rs) -> {

			while (rs.next() ) {
				Users user = new Users();
				user.setId(rs.getInt("ID"));
				user.setName(rs.getString("NAME"));
				user.setLocation(rs.getString("LOCATION"));
				users.add(user);
			}	
			
			return users;
		}, params);
		
		//Approach-3: Using java8 Lambda expression End
		
		

		return users;
	}

	public Users findById(Integer id) {

		//Approach-1: Using Custom extractor class: start
		/*
		Object[] params = { id };
		Users users = jdbcTemplate.query(DBQueries.SELECT_USER_BY_ID, new UserExtractorById(), params);
		*/
		//Approach-1: Using Custom extractor class: End
		
		
		//Approach-2: Using anonymous inner class start
		
		/*
		
		Object[] params = { id };
		Users user = jdbcTemplate.query(DBQueries.SELECT_USER_BY_ID, new ResultSetExtractor<Users>() {
			Users user = new Users();
			@Override
			public Users extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					user.setId(rs.getInt("ID"));
					user.setName(rs.getString("NAME"));
					user.setLocation(rs.getString("LOCATION"));
				}
				return user;
			}
		}, params);
		
		*/
		//Approach-2: Using anonymous inner class end

		//Approach-3: Using java8 Lambda expression start (recommended approach)
		
		Object[] params = { id };

		Users user = new Users();

		jdbcTemplate.query(DBQueries.SELECT_USER_BY_ID, (rs) -> {
			while (rs.next()) {
				user.setId(rs.getInt("ID"));
				user.setName(rs.getString("NAME"));
				user.setLocation(rs.getString("LOCATION"));
			}
			return user;
		}, params);

		//Approach-3: Using java8 Lambda expression End
		
		return user;
	}
	
	
	public int save(Users user) {
		// No need to pass id, Id will be auto generated, please refer schema.sql in resources folder
		Object[] params = {  user.getName(), user.getLocation() };
		int count = jdbcTemplate.update(DBQueries.INSERT_INTO_USERS, params);
		return count;
		
	}
}
