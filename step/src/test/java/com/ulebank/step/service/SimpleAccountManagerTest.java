package com.ulebank.step.service;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ulebank.step.domain.Account;
import com.ulebank.step.repository.AccountDao;
import com.ulebank.step.repository.InMemoryAccountDao;

public class SimpleAccountManagerTest {

    private SimpleAccountManager accountManager;
    
    private List<Account> accounts;
    
    private static int ACCOUNT_COUNT = 3;
    
    private static String account1 = "123456789";
    private static Double comision1 = new Double(3.5);
    
    private static String account2 = "987654321";
    private static Double comision2 = new Double(1.7);
    
    private static String account3 = "987456321";
    private static Double comision3 = new Double(2.45);
    
    private static int POSITIVE_PRICE_INCREASE = 10;
    
    @Before
    public void setUp() throws Exception {
        accountManager = new SimpleAccountManager();
        accounts = new ArrayList<Account>();
        
        // stub up a list of products
        Account account = new Account();
        account.setId(account1);
        account.setComision(comision1);
        accounts.add(account);
        
        account = new Account();
        account.setId(account2);
        account.setComision(comision2);
        accounts.add(account);
        
        account = new Account();
        account.setId(account3);
        account.setComision(comision3);
        accounts.add(account);
        
        AccountDao accountDao = new InMemoryAccountDao(accounts);
        accountManager.setAccountDao(accountDao);
        
        //productManager.setProducts(products);
    }

    @Test
    public void testGetProductsWithNoProducts() {
    	accountManager = new SimpleAccountManager();
    	accountManager.setAccountDao(new InMemoryAccountDao(null));
    	assertNull(accountManager.getAccounts());
    }

    @Test
    public void testGetProducts() {
    	List<Account> accounts = accountManager.getAccounts();
    	assertNotNull(accounts);
    	assertEquals(accounts.size(), accountManager.getAccounts().size());
    	assertEquals(ACCOUNT_COUNT, accounts.size());
    	
    	assertEquals(accounts.get(0).getId(), account1);
    	assertTrue(accounts.get(0).getComision() == comision1);
    	
    	assertEquals(accounts.get(1).getId(), account2);
    	assertTrue(accounts.get(1).getComision() == comision2);
    	
    	assertEquals(accounts.get(2).getId(), account3);
    	assertTrue(accounts.get(2).getComision() == comision3);      
    }   
    
    @Test
    public void testIncreasePriceWithNullListOfProducts() {
        try {
        	accountManager = new SimpleAccountManager();
        	accountManager.setAccountDao(new InMemoryAccountDao(null));
        	accountManager.changeComision(25.2, "123456789");
        }
        catch(NullPointerException ex) {
        	fail("Products list is null.");
        }
    }
    
    @Test
    public void testIncreasePriceWithEmptyListOfProducts() {
        try {
        	accountManager = new SimpleAccountManager();
        	accountManager.setAccountDao(new InMemoryAccountDao(new ArrayList<Account>()));
        	accountManager.changeComision(25.2, "123456789");
        }
        catch(Exception ex) {
        	fail("Products list is empty.");
        }           
    }
    
    @Test
    public void testIncreasePriceWithPositivePercentage() {
    	accountManager.changeComision(25.2, "123456789");
    	List<Account> accounts = accountManager.getAccounts();
    	Account account = accounts.get(0);
    	assertEquals(25.2, account.getComision(), 0);       
    }
}
