package com.spring.jdbc.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.spring.jdbc.app.model.Users;


public class UserExtractor implements ResultSetExtractor<List<Users>> {

	@Override
	public List<Users> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		List<Users> users = new ArrayList<>();
		
		while (rs.next() ) {
			Users user = new Users();
			user.setId(rs.getInt("ID"));
			user.setName(rs.getString("NAME"));
			user.setLocation(rs.getString("LOCATION"));
			users.add(user);
		}	
		
		return users;
	}
	
	

}
