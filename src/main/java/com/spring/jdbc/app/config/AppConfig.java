package com.spring.jdbc.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.jdbc.app.util.PaswordUtils;

@Configuration
public class AppConfig {

	public AppConfig() {
		System.out.println("AppConfig() 0 param constructor");
	}
	
	//To customize the object creation we use the below 
	@Bean
	public PaswordUtils paswordUtils() {
		System.out.println("paswordUtils()");
		PaswordUtils pwd=new PaswordUtils("SHA-1");
		return pwd;
	}
	

}
