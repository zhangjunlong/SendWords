package com.openthinks.woms.message.rest;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.openthinks.woms.message.Message;
import com.openthinks.woms.message.service.MessageService;
import com.openthinks.woms.rest.GenericRestfulController;

@Results({ @Result(name = "success", type = "redirectAction", params = {
		"actionName", "message" }) })
public class MessageController extends GenericRestfulController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Message model = new Message();

	com.openthinks.woms.rest.Message msg;

	MessageService messageService;

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	@Override
	public Object getModel() {
		if (msg != null)
			return msg;
		else
			return model;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub

	}

	@Override
	public HttpHeaders show() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpHeaders index() {
		return null;
	}

	@Override
	public HttpHeaders create() {
		try {
			messageService.create(model);

			msg = new com.openthinks.woms.rest.Message(
					com.openthinks.woms.rest.Message.SUCCESS);

			return new DefaultHttpHeaders("success").setLocationId(model
					.getId());
		} catch (Exception e) {
			msg = new com.openthinks.woms.rest.Message(
					com.openthinks.woms.rest.Message.FAILURE);

			return ACCEPTED;
		}
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
