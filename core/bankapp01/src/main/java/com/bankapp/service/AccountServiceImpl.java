package com.bankapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.dao.Account;
import com.bankapp.dao.AccountDao;
import com.bankapp.exceptions.BankAccountNotFoundException;

@Service(value = "accountService")
public class AccountServiceImpl implements AccountService{

	private AccountDao accountDao;
	
	@Autowired
	public AccountServiceImpl(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public List<Account> getAll() {
		return accountDao.getAll();
	}

	@Override
	public Account getById(int id) {
		Account account=accountDao.getById(id);
		if(account==null)
			throw new BankAccountNotFoundException("account with id " + id +" is not found");
		return account;
	}

	@Override
	public void addAccount(Account account) {
		accountDao.addAccount(account);
	}

	@Override
	public void deleteAccount(int id) {
		accountDao.deleteAccount(id);
	}

	@Override
	public void transfer(int fromId, int toId, double amount) {
		Account fromAcc=accountDao.getById(fromId);
		Account toAcc=accountDao.getById(toId);
		
		fromAcc.setBalance(fromAcc.getBalance()-amount);
		toAcc.setBalance(toAcc.getBalance()+amount);
		accountDao.updateAccount(fromAcc);
		accountDao.updateAccount(toAcc);
		
	}

	@Override
	public void deposit(int id, double amount) {
		Account acc=accountDao.getById(id);

		acc.setBalance(acc.getBalance()+amount);
		accountDao.updateAccount(acc);
	}

	@Override
	public void withdraw(int id, double amount) {
		Account acc=accountDao.getById(id);

		acc.setBalance(acc.getBalance()-amount);
		accountDao.updateAccount(acc);
	}

}






