package com.ulebank.step.web;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.ulebank.step.domain.Account;
import com.ulebank.step.repository.InMemoryAccountDao;
import com.ulebank.step.service.SimpleAccountManager;


public class AccountControllerTest {
    
    @Test
    public void testHandleRequestView() throws Exception{		
        AccountController controller = new AccountController();
        SimpleAccountManager sam = new SimpleAccountManager();
        sam.setAccountDao(new InMemoryAccountDao(new ArrayList<Account>()));
        controller.setAccountManager(sam);
        ModelAndView modelAndView = controller.handleRequest(null, null);
        assertEquals("accounts", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        //Map modelMap = (Map) modelAndView.getModel().get("model");
        
        Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
        assertNotNull(modelMap);
    }

}