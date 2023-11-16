package com.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dao.Account;
import com.bankapp.service.AccountService;

@RestController
public class AcountCrudController {

	private AccountService accountService;

	@Autowired
	public AcountCrudController(AccountService accountService) {
		this.accountService = accountService;
	}

	//get all the accounts
	@GetMapping(path = "accounts")
	public List<Account> getAll(){
		return accountService.getAll();
	}
	
	//get by id
	@GetMapping(path = "accounts/{id}")
	public Account getById(@PathVariable(name="id")int id){
		return accountService.getById(id);
	}
	
	//update account
	
	//delete account
	
	//add account
	
}







