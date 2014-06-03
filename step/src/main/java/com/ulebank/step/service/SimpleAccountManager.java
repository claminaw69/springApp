package com.ulebank.step.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ulebank.step.domain.Account;
import com.ulebank.step.repository.AccountDao;

@Component
public class SimpleAccountManager implements AccountManager{

	private static final long serialVersionUID = 1L;

    @Autowired
    private AccountDao accountDao;
	
	
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public List<Account> getAccounts() {
		return accountDao.getAccountList();
	}


	public void changeComision(double comision, String id) {
		List<Account> accounts = this.accountDao.getAccountList();
 		if(accounts != null){
			for(Account account : accounts){
				if(id.equals(account.getId())){
					account.setComision(comision);
					accountDao.saveAccount(account);
				}
			}
		}
	}

}
