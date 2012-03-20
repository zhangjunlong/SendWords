package com.openthinks.woms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.openthinks.woms.profile.rest.RankController;
import com.openthinks.woms.rest.SignController;

/**
 * An interceptor of users' authentication
 * 
 * @author Zhang Junlong
 * 
 */
public class AuthenticationInterceptor implements Interceptor {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();

		Object action = invocation.getAction();

		if (action instanceof SignController) {
			return invocation.invoke();
		}

		if (action instanceof RankController) {
			return invocation.invoke();
		}

		String accountId = (String) session.getAttribute("id");
		if (null == accountId) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return null;
		} else {
			return invocation.invoke();
		}
	}
}
