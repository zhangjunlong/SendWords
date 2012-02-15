package com.openthinks.woms.rest;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.rest.HttpHeaders;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Validateable;
import com.opensymphony.xwork2.ValidationAwareSupport;

/**
 * Generic controller
 * 
 * @author Zhang Junlong
 * 
 */
public abstract class GenericRestfulQueryController extends
		ValidationAwareSupport implements ModelDriven<Object>, Validateable,
		SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Map<String, Object> session;

	/**
	 * Default response message
	 */
	protected Message message;

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * Find
	 * 
	 * Method: POST
	 * 
	 * URI: /{ID}
	 * 
	 * @return
	 */
	abstract public String find();

}