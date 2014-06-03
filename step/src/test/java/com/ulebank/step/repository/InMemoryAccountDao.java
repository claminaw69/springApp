package com.ulebank.step.repository;

import java.util.List;

import com.ulebank.step.domain.Account;


public class InMemoryAccountDao implements AccountDao {
	
	private List<Account> accountList;
	
	public InMemoryAccountDao(List<Account> accountList){
		this.accountList = accountList;
	}

	public List<Account> getAccountList() {
		return accountList;
	}

	public void saveAccount(Account account) {
	}



}