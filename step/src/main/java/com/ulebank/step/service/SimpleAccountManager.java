package com.ulebank.step.service;

import java.util.List;

import com.ulebank.step.domain.Account;

public class SimpleAccountManager implements AccountManager{

	private static final long serialVersionUID = 1L;

    private List<Account> accounts;
	
	
	
	public List<Account> getAccounts() {
		return accounts;
	}
	
	public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }


	public void changeComision(double comision, String id) {
		if(accounts != null){
			for(Account account : accounts){
				if(id.equals(account.getId())){
					account.setComision(comision);
				}
			}
		}
	}

}
