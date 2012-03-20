package com.openthinks.woms.account.rest;

import java.util.Collection;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.openthinks.woms.account.Account;
import com.openthinks.woms.account.service.AccountService;
import com.openthinks.woms.rest.GenericRestfulController;

@Results({ @Result(name = "success", type = "redirectAction", params = {
		"actionName", "account" }) })
public class AccountController extends GenericRestfulController {

	private static final long serialVersionUID = 1L;

	private int id;

	private Account model = new Account();

	private Collection<Account> list;

	private AccountService accountService;

	@Override
	public void validate() {
		// TODO Auto-generated method stub

	}

	@Override
	public HttpHeaders show() {

		try {
			model = accountService.find(model.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new DefaultHttpHeaders("index").disableCaching();
	}

	@Override
	public HttpHeaders index() {
		try {
			list = accountService.find();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new DefaultHttpHeaders("index").disableCaching();
	}

	@Override
	public HttpHeaders create() {
		try {
			accountService.create(model);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new DefaultHttpHeaders("success").setLocationId(model.getId());
	}

	@Override
	public String update() {
		try {
			accountService.update(model);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "success";
	}

	@Override
	public String destroy() {
		try {
			accountService.delete(model.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "success";
	}

	@Override
	public Object getModel() {
		if (message != null)
			return message;
		else
			return (list != null ? list : model);
	}

	public void setAccountService(AccountService accountGroupService) {
		this.accountService = accountGroupService;
	}

	public void setId(int id) {
		this.id = id;
	}
}
