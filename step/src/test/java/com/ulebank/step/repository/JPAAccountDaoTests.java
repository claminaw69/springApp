package com.ulebank.step.repository;

import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ulebank.step.domain.Account;
public class JPAAccountDaoTests {

    private ApplicationContext context;
    private AccountDao accountDao;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        accountDao = (AccountDao) context.getBean("accountDao");
    }

    @Test
    public void testGetProductList() {
        List<Account> accounts = accountDao.getAccountList();
        assertEquals(accounts.size(), 3, 0);	   
    }

    @Test
    public void testSaveProduct() {
        List<Account> accounts = accountDao.getAccountList();

        Account a = accounts.get(0);
        Double comision = a.getComision();
        a.setComision(7.35);
        accountDao.saveAccount(a);

        List<Account> updatedAccounts = accountDao.getAccountList();
        Account a2 = updatedAccounts.get(0);
        assertEquals(a2.getComision(), 7.35, 0);

        a2.setComision(comision);
        accountDao.saveAccount(a2);
    }
}