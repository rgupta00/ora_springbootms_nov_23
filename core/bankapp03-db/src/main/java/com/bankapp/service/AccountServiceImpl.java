package com.bankapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.dao.Account;
import com.bankapp.dao.AccountRepo;
import com.bankapp.exceptions.BankAccountNotFoundException;

@Service(value = "accountService")
public class AccountServiceImpl implements AccountService{

	private AccountRepo accountRepo;
	
	@Autowired
	public AccountServiceImpl(AccountRepo accountRepo) {
		this.accountRepo = accountRepo;
	}

	@Override
	public List<Account> getAll() {
		return accountRepo.findAll();
	}

	@Override
	public Account getById(int id) {
		 Optional<Account> accountOptional = accountRepo.findById(id);
		return accountOptional.orElseThrow(()->  new BankAccountNotFoundException("account not found"));
	}

	@Override
	public void addAccount(Account account) {
		accountRepo.save(account);
	}

	@Override
	public void deleteAccount(int id) {
		accountRepo.delete(getById(id));
	}

	@Override
	public void transfer(int fromId, int toId, double amount) {
		Account fromAcc=getById(fromId);
		Account toAcc=getById(toId);
		
		fromAcc.setBalance(fromAcc.getBalance()-amount);
		toAcc.setBalance(toAcc.getBalance()+amount);
		accountRepo.save(fromAcc);
		accountRepo.save(toAcc);
		
	}

	@Override
	public void deposit(int id, double amount) {
		Account acc=getById(id);

		acc.setBalance(acc.getBalance()+amount);
		accountRepo.save(acc);
	}

	@Override
	public void withdraw(int id, double amount) {
		Account acc=getById(id);

		acc.setBalance(acc.getBalance()-amount);
		accountRepo.save(acc);
	}

}






