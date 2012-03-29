package com.openthinks.woms.rest;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.rest.DefaultHttpHeaders;
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
public abstract class GenericRestfulController extends ValidationAwareSupport
		implements ModelDriven<Object>, Validateable, SessionAware {

	/**
	 * HTTP Header of code 202
	 */
	protected static HttpHeaders ACCEPTED;

	static {
		ACCEPTED = new DefaultHttpHeaders();
		ACCEPTED.setStatus(202);
	}

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
	 * Method GET
	 * 
	 * URI: /{id}
	 */
	abstract public HttpHeaders show();

	/**
	 * List all
	 * 
	 * Method: GET
	 * 
	 * URI: /
	 * 
	 * @return
	 */
	abstract public HttpHeaders index();

	/**
	 * Create a new order
	 * 
	 * Method: POST
	 * 
	 * URI: /order
	 * 
	 * @return
	 */
	abstract public HttpHeaders create();

	/**
	 * Update
	 * 
	 * Method: PUT
	 * 
	 * URI: /{id}
	 * 
	 * @return
	 */
	abstract public String update();

	/**
	 * Delete
	 * 
	 * Method: DELETE
	 * 
	 * URI: /{ID}
	 * 
	 * @return
	 */
	abstract public String destroy();

}