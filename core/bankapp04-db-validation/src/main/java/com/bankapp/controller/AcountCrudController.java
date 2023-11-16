package com.bankapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	//ResponsEntity= data + status code
	
	//get all the accounts
	@GetMapping(path = "accounts")
	public List<Account> getAll(){
		if(1==1)
			throw new RuntimeException();
		return accountService.getAll();
	}
	
	//get by id
	@GetMapping(path = "accounts/{id}")
	public Account getById(@PathVariable(name="id")int id){
		return accountService.getById(id);
	}
	
	//update account
	
	//delete account
	@DeleteMapping(path = "accounts/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable(name="id")int id){
		 accountService.deleteAccount(id);
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
//	//add account
//	@PostMapping(path = "accounts")
//	public Account addAccount(@RequestBody  Account account) {
//		accountService.addAccount(account);
//		return account;
//	}
	
	//add account
		@PostMapping(path = "accounts")
		public ResponseEntity<Account> addAccount(@RequestBody @Valid  Account account) {
			accountService.addAccount(account);
			return ResponseEntity.status(HttpStatus.CREATED).body(account);
		}
	
}







