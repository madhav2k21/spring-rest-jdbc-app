package com.spring.jdbc.app.common;

public interface DBQueries {

	String SELECT_USER_BY_ID = "SELECT ID, NAME, LOCATION FROM USERS WHERE ID=? ";
	String SELECT_ALL_USERS = "SELECT ID, NAME, LOCATION FROM USERS";
	String INSERT_INTO_USERS = "INSERT INTO USERS (NAME, LOCATION ) VALUES(?,?)";

}
