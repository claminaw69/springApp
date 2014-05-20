package com.ulebank.step.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ulebank.step.service.ChangeComision;
import com.ulebank.step.service.AccountManager;

@Controller
@RequestMapping(value="/changeComision.htm")
public class ChangeComisionController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private AccountManager accountManager;

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(ChangeComision changeComision, BindingResult result)
    {
//        if (result.hasErrors()) {
//            return "changeComision";
//        }
		
        double change = changeComision.getComision();
        logger.info("change comision to: " + change + "%.");
        
        String id = changeComision.getId();
        
        accountManager.changeComision(change, id);

        return "redirect:/accounts.htm";
    }

    @RequestMapping(method = RequestMethod.GET)
    protected ChangeComision formBackingObject(HttpServletRequest request) throws ServletException {
        ChangeComision changeComision = new ChangeComision();
        changeComision.setId(request.getParameter("id"));
        return changeComision;
    }

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public AccountManager getAccountManager() {
        return accountManager;
    }

}