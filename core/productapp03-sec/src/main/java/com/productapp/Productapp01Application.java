package com.productapp;

import java.math.BigDecimal;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.entities.Product;
import com.productapp.entities.UserEntity;
import com.productapp.repo.ProductDao;
import com.productapp.service.UserService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
@OpenAPIDefinition(info = @Info(title = "productapp API", version = "2.0" ,
description = "oracle fin productapp API"))

@SpringBootApplication
public class Productapp01Application implements CommandLineRunner {

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(Productapp01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productDao.save(new Product("thinkpad", new BigDecimal(120000)));
		productDao.save(new Product("hp printer", new BigDecimal(23000)));
		
		userService.addUserEntity(new UserEntity("raj","raj123", List.of("ROLE_MGR","ROLE_EMP","ROLE_ADMIN")));
		userService.addUserEntity(new UserEntity("ekta","ekta123", List.of("ROLE_MGR","ROLE_EMP")));
		userService.addUserEntity(new UserEntity("gunika","ekta123", List.of("ROLE_EMP")));
		
		//print the user details
		
		System.out.println(userService.findByUsername("raj"));
	}

}
