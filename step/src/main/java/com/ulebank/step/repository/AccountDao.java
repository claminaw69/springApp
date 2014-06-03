package com.ulebank.step.repository;

import java.util.List;

import com.ulebank.step.domain.Account;

public interface AccountDao {
    public List<Account> getAccountList();

    public void saveAccount(Account account);
}
