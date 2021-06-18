package com.spring.jdbc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.spring.jdbc.app.service.UsrService;

@SpringBootApplication
public class SpringRestJdbcAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringRestJdbcAppApplication.class, args);
//		DateUtils bean = context.getBean(DateUtils.class);
		
		UsrService userService = context.getBean(UsrService.class);
		userService.saveUser();
//		System.exit(0);
	}

}
