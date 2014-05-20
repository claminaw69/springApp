package com.ulebank.step.web;


import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.ulebank.step.service.SimpleAccountManager;


public class AccountControllerTest {
    
    @Test
    public void testHandleRequestView() throws Exception{		
        AccountController controller = new AccountController();
        controller.setAccountManager(new SimpleAccountManager());
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        assertEquals("accounts", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        @SuppressWarnings("unchecked")
        Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
        assertNotNull(modelMap);
    }

}