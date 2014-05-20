package com.ulebank.step.domain;

import static org.junit.Assert.*;

import org.junit.Test;


public class AccountTest {

    @Test
    public void testAccount() throws Exception{		
       Account account = new Account();
       assertNotNull(account);
       assertNull(account.getId());
       account.setId("123456789");
       account.setComision(3.5);
       assertNotNull(account.getId());
       assertEquals("123456789", account.getId());
    }

}