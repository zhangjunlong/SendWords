package com.openthinks.woms.system;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.openthinks.woms.account.Account;
import com.openthinks.woms.account.AccountGroup;
import com.openthinks.woms.account.service.AccountService;
import com.openthinks.woms.system.configuration.PropertiesReader;

/**
 * Servlet implementation class InitiateServlet
 */
public class InitiateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AccountService accountService;

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InitiateServlet() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// Initiate a default account
		PropertiesReader pr = new PropertiesReader("system.properties");
		String un = pr.getProperties("admin.username");
		String pw = pr.getProperties("admin.password");

		AccountGroup accGroup = new AccountGroup();
		accGroup.setName("admin");

		Account defAcc = new Account();
		defAcc.setName(un);
		defAcc.setPassword(pw);
		defAcc.setAccountGroup(accGroup);
		try {
			WebApplicationContext ctx = WebApplicationContextUtils
					.getRequiredWebApplicationContext(config
							.getServletContext());

			accountService = (AccountService) ctx.getBean("accountService");
			accountService.create(defAcc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
