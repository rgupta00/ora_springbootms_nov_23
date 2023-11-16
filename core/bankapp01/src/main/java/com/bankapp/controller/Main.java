package com.bankapp.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bankapp.AppConfig;
import com.bankapp.dao.Account;
import com.bankapp.service.AccountService;
import com.bankapp.service.AccountServiceImpl;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		AccountService accountService=ctx.getBean("accountService",AccountService.class);
		List<Account> accounts = accountService.getAll();
		accounts.forEach(a-> System.out.println(a));
	}
}
