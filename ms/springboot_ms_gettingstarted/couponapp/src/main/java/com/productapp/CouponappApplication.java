package com.productapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class CouponappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouponappApplication.class, args);
	}

}
