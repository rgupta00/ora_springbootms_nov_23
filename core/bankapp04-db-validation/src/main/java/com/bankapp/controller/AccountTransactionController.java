package com.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.DepositDto;
import com.bankapp.dto.TransferDto;
import com.bankapp.dto.WithdrawDto;
import com.bankapp.service.AccountService;


//http://localhost:9090/bankapp/transaction/transfer
@RestController
@RequestMapping(path  ="transaction")
public class AccountTransactionController {

	private Environment environment;
	
	private AccountService accountService;
	
	@Autowired
	public AccountTransactionController(Environment environment, AccountService accountService) {
		this.environment = environment;
		this.accountService = accountService;
	}
	// transfer the amount
	@PostMapping(path = "transfer")
	public String transfer(@RequestBody  TransferDto transferDto) {
		accountService.transfer(transferDto.getFromAccountId(), transferDto.getToAccountId(), 
				transferDto.getAmount());
		String message =environment.getProperty("UserInterface.TRANSFER_SUCCESS");
		return message;
	}
	// deposit the amount
	@PostMapping(path = "deposit")
	public String deposit(@RequestBody DepositDto depositDto) {
		accountService.deposit(depositDto.getAccountId(), depositDto.getAmount());
		return "deposit done succesfully";
	}
	
	// withdraw the amount
	@PostMapping(path = "withdraw")
	public String withdraw(@RequestBody WithdrawDto withdrawDto) {
		accountService.withdraw(withdrawDto.getAccountId(), withdrawDto.getAmount());
		return "withdraw done succesfully";
	}
	
	
}
