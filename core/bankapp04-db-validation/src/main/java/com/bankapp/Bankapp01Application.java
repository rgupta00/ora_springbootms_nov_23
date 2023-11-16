package com.bankapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bankapp.dao.Account;
import com.bankapp.dao.AccountRepo;

@SpringBootApplication
public class Bankapp01Application implements CommandLineRunner{

	@Autowired
	private AccountRepo accountRepo;
	
	//u want to create account in h2 db as soon as project start
	public static void main(String[] args) {
		SpringApplication.run(Bankapp01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		accountRepo.save(new Account("raj", 20000.00));
		accountRepo.save(new Account("ekta", 20000.00));
		
	}
}
