package com.openthinks.woms.product.rest;

import java.util.Collection;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;

import com.openthinks.woms.product.Season;
import com.openthinks.woms.product.service.SeasonService;
import com.openthinks.woms.rest.GenericRestfulController;
import com.openthinks.woms.rest.Message;

@Results({ @Result(name = "success", type = "redirectAction", params = {
		"actionName", "season" }) })
public class SeasonController extends GenericRestfulController {

	/**
	 * Serial versionUID
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private SeasonService seasonService;

	private String id;

	private Season model = new Season();

	private Collection<Season> list;

	public HttpHeaders create() {
		try {
			seasonService.create(model);

			addActionMessage("New brand created successfully");
		} catch (Exception e) {
			e.printStackTrace();
			addFieldError("clientName", "The client name is empty");

			message = new Message(Message.FAILURE, e.getMessage());
		}

		return new DefaultHttpHeaders("success").setLocation(model.getCode());
	}

	public HttpHeaders show() {
		try {
			model = seasonService.find(Integer.parseInt(id));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new DefaultHttpHeaders("show");
	}

	@Override
	public HttpHeaders index() {
		try {
			list = seasonService.find();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new DefaultHttpHeaders("index").disableCaching();
	}

	@Override
	public String update() {
		try {
			seasonService.update(model);

			addActionMessage("Order updated successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "success";
	}

	@Override
	public String destroy() {
		try {
			seasonService.delete(Integer.parseInt(id));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Object getModel() {
		if (message != null)
			return message;
		else
			return (list != null ? list : model);
	}

	public void setId(String id) {
		if (id != null) {
			// this.model = id;
		}
		this.id = id;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub

	}

}
