package com.openthinks.woms.rest;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Validateable;
import com.opensymphony.xwork2.ValidationAwareSupport;
import com.openthinks.woms.account.Account;
import com.openthinks.woms.account.Role;
import com.openthinks.woms.account.service.AccountService;
import common.Logger;

/**
 * Signing Controller
 * 
 * @author Zhang Junlong
 * 
 */
@Results({ @Result(name = "success", type = "redirectAction", params = {
		"actionName", "sign" }) })
public class SignController extends ValidationAwareSupport implements
		ModelDriven<Object>, Validateable {
	/**
	 * Default serial version UID
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(SignController.class);

	// Model for interacting
	private Account model = new Account();

	private Message msg;

	@Autowired
	private AccountService accountService;

	/**
	 * Sign in a account
	 * 
	 * URI： /main/id/in
	 * 
	 * @return
	 */
	public HttpHeaders in() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();

		Account account = accountService.authorize(model.getUserId(),
				model.getPassword());

		if (account != null) {

			session.put("id", account.getId());
			session.put("name", account.getName());
			session.put("role", account.getRole());
			if (account.getRole().equals("admin"))
				session.put("roleName", "管理员");
			else
				session.put("roleName", "普通用户");

			msg = new Message(Message.SUCCESS, "console");
			msg.setExtend(account);

			if (account.getRole().equals(Role.ADMIN)) {

				logger.info("Account: " + account.getId()
						+ " signed in as a console user.");

				return new DefaultHttpHeaders("success").setLocationId(model
						.getUserId());
			} else {

				msg.setDescription("client");
				msg.setExtend(account);
				logger.info("Account: " + account.getId()
						+ " signed in as a user.");

				return new DefaultHttpHeaders("success").setLocation(model
						.getUserId());
			}

		} else {
			session.put("message", "login failed");

			msg = new Message(Message.FAILURE, "密码或者用户名错误");

			return new DefaultHttpHeaders("error").setLocationId(model.getId());
		}
	}

	public String out() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath() + "/index.html");

		return null;
	}

	/**
	 * 参数验证
	 */
	public void validate() {

	}

	public Object getModel() {
		if (msg != null)
			return msg;
		else
			return model;
	}

}
