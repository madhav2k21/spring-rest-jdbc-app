package com.spring.jdbc.app.util;

public class BookService {
	
	
	public String getBook(String name, int id) {
		if(name.startsWith("Z")) {
			return "Old: "+name+id;
		}
		return name+id;
	}

}
