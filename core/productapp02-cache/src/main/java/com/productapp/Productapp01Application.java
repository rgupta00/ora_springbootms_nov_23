package com.productapp;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.productapp.entities.Product;
import com.productapp.repo.ProductDao;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
@OpenAPIDefinition(info = @Info(title = "productapp API", version = "2.0" ,
description = "oracle fin productapp API"))
@EnableScheduling
@SpringBootApplication
public class Productapp01Application implements CommandLineRunner {

	@Autowired
	private ProductDao productDao;
	
	public static void main(String[] args) {
		SpringApplication.run(Productapp01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productDao.save(new Product("thinkpad", new BigDecimal(120000)));
		productDao.save(new Product("hp printer", new BigDecimal(23000)));
	}

}
