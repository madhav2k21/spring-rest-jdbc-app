package com.spring.jdbc.app.common;

import com.spring.jdbc.app.model.Users;

public class TestApp {
	public static void main(String[] args) {
		String s1=new String("test");
		String s2=new String("test");
		System.out.println(s1.equals(s2));
		Users u1=new Users(101,"TestUser", "Hyd");
		Users u2=new Users(101,"TestUser", "Hyd");
		System.out.println(u1.equals(u2));
		
	}
}
