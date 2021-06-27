package com.spring.jdbc.app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.jdbc.app.model.Users;

//@SpringBootTest
class ITUserControllerTest {

//	@Test
	public void testFindAllUsers() throws JSONException {
		TestRestTemplate tr=new TestRestTemplate();
		ResponseEntity<String> entity = tr.getForEntity("http://localhost:8082/v1/users", String.class);
		HttpStatus status = entity.getStatusCode();
		System.out.println(status);
		System.out.println(entity.getBody());
		JSONAssert.assertEquals("[{\"id\":101,\"name\":\"Anuradha\",\"location\":\"Hyderabad\"},{\"id\":102,\"name\":\"Praveen\",\"location\":\"Visakapatnam\"},{\"id\":103,\"name\":\"Priyanka\",\"location\":\"Hyderabad\"},{\"id\":104,\"name\":\"Siva\",\"location\":\"Vizag\"},{\"id\":105,\"name\":\"Latha\",\"location\":\"Vijayawada\"},{\"id\":106,\"name\":\"Madhav\",\"location\":\"Hyderabad\"}]", entity.getBody(), false);
		
	}
	
//	@Test
	public void testSaveUser() throws JSONException, JsonProcessingException {
		
		TestRestTemplate tr=new TestRestTemplate();
		Users user = new Users("madhav", "HYD");
		
		HttpHeaders header=new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Users> hentity=new HttpEntity<>(user, header);
		Object[] params= {};
		ResponseEntity<String> entity = tr.postForEntity("http://localhost:8082/v1/users",hentity, String.class, params);
 
		
		HttpStatus status = entity.getStatusCode();
		
		System.out.println(entity.getBody()+" "+status);
		ObjectMapper mapper=new ObjectMapper();
		
		String expJsonRespo = mapper.writeValueAsString(entity.getBody());
		String jsonRespo = mapper.writeValueAsString("User is saved successfully");
		
		JSONAssert.assertEquals(expJsonRespo, jsonRespo, false);
//		assertEquals("User is saved successfully",entity.getBody());
		
		assertEquals(HttpStatus.CREATED, entity.getStatusCode());
		
	
		
		
		
		
		
	}
	

}
