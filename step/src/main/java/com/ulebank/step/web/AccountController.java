package com.ulebank.step.web;


	import java.io.IOException;
	import java.util.Date;
	import java.util.HashMap;
	import java.util.Map;

	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import org.apache.commons.logging.Log;
	import org.apache.commons.logging.LogFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.servlet.ModelAndView;

	import com.ulebank.step.service.AccountManager;

	@Controller
	public class AccountController {

	    protected final Log logger = LogFactory.getLog(getClass());

	    @Autowired
	    private AccountManager accountManager;

	    @RequestMapping(value="/accounts.htm")
	    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	    	String now = (new Date()).toString();
	        logger.info("Returning hello view with " + now);
	        
	        System.out.println("@@@@@@@@@@@@cuentas: "+accountManager.getAccounts().size()+"@@@@@@@@@@@@@@@@");

	        Map<String, Object> myModel = new HashMap<String, Object>();
	        myModel.put("accounts", this.accountManager.getAccounts());

	        return new ModelAndView("accounts", "model", myModel);
	    }


	    public void setAccountManager(AccountManager accountManager) {
	        this.accountManager = accountManager;
	    }
	}