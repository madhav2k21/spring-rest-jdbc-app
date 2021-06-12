package com.spring.jdbc.app.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BookServiceTest {

	@Test
	public void testOldBookService() {
		BookService bService=new BookService();
		String book = bService.getBook("ZBook", 21);
		String EXPECTED="Old: ZBook"+21;
		assertEquals(EXPECTED, book);
	}
	
	@Test
	public void testNewBookService() {
		BookService bService=new BookService();
		String book = bService.getBook("ABook", 21);
		String EXPECTED="ABook"+21;
		assertEquals(EXPECTED, book);
	}

}
