package com.ulebank.step.service;

import java.io.Serializable;
import java.util.List;

import com.ulebank.step.domain.Account;

public interface AccountManager extends Serializable{

	public void changeComision(double comision, String id);
    
    public List<Account> getAccounts();
}
