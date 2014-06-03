package com.ulebank.step.web;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.ulebank.step.domain.Account;
import com.ulebank.step.repository.AccountDao;
import com.ulebank.step.service.ChangeComision;
import com.ulebank.step.service.SimpleAccountManager;

public class ChangeComisionControllerTest {
	
	private SimpleAccountManager simpleAccountManager;
	private Account account1;
	private Account account2;
    private ApplicationContext context;
    private AccountDao accountDao;
	
	@Before
	public void setUp(){
		context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        accountDao = (AccountDao) context.getBean("accountDao");
		simpleAccountManager = new SimpleAccountManager();
		List <Account> accounts = new ArrayList<Account>();
		account1 = new Account();
		account2 = new Account();
		account1.setId("123456789");
		account1.setComision(3.5);
		account2.setId("987654321");
		account2.setComision(2.0);
		accounts.add(account1);
		accounts.add(account2);
		simpleAccountManager.setAccountDao(accountDao);
	}
	
	@Test
	public void onSubmit(){
		ChangeComisionController controller = new ChangeComisionController();
		controller.setAccountManager(simpleAccountManager);
		ChangeComision changeComision = new ChangeComision();
		changeComision.setId("123456789");
		changeComision.setComision(15.3);
		String test = controller.onSubmit(changeComision, null);
		assertEquals("redirect:/accounts.htm", test);
		assertTrue(15.3 == simpleAccountManager.getAccounts().get(0).getComision());	
	}

}







