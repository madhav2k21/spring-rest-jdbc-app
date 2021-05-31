package com.spring.jdbc.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.spring.jdbc.app.model.Users;

public class UserExtractorById implements ResultSetExtractor<Users> {

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

}
