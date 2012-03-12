package com.openthinks.woms.system.rest;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.openthinks.woms.account.Account;
import com.openthinks.woms.rest.GenericRestfulController;
import com.openthinks.woms.system.configuration.PropertiesReader;

@Results({ @Result(name = "success", type = "redirectAction", params = {
		"actionName", "initaccount" }) })
public class Initaccount extends GenericRestfulController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private InitAccountData model = new InitAccountData();

	@Override
	public Object getModel() {
		return model;
	}

	@Override
	public void validate() {
		PropertiesReader pr = new PropertiesReader("system.properties");
		String pw = pr.getProperties("admin.password");
	}

	@Override
	public HttpHeaders show() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpHeaders index() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpHeaders create() {
		Account account = new Account();
		try {
			BeanUtils.copyProperties(account, model);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return new DefaultHttpHeaders("success").setLocationId(model.getId());
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String destroy() {
		// TODO Auto-generated method stub
		return null;
	}

}

class InitAccountData extends Account {
	private String authPwd;

	public String getAuthPwd() {
		return authPwd;
	}

	public void setAuthPwd(String authPwd) {
		this.authPwd = authPwd;
	}
}
