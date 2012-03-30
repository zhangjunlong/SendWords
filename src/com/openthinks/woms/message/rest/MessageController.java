package com.openthinks.woms.message.rest;

import java.util.Collection;
import java.util.Map;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.opensymphony.xwork2.ActionContext;
import com.openthinks.woms.account.service.AccountService;
import com.openthinks.woms.message.Message;
import com.openthinks.woms.message.service.MessageService;
import com.openthinks.woms.rest.GenericRestfulController;
import common.Logger;

@Results({ @Result(name = "success", type = "redirectAction", params = {
		"actionName", "message" }) })
public class MessageController extends GenericRestfulController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger
			.getLogger(MessageController.class);

	Message model = new Message();

	Collection<Message> msgs;

	com.openthinks.woms.rest.Message msg;

	MessageService messageService;

	AccountService accountService;

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	@Override
	public Object getModel() {
		if (msg != null)
			return msg;
		else
			return (null != msgs ? msgs : model);
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
		try {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			long uid = (Long) session.get("id");

			msgs = messageService.retrieveMsgs(uid);

			msg = new com.openthinks.woms.rest.Message(
					com.openthinks.woms.rest.Message.SUCCESS);

			msg.setExtend(msgs);

			return new DefaultHttpHeaders("index").disableCaching();

		} catch (Exception e) {
			logger.debug(e);

			msg = new com.openthinks.woms.rest.Message(
					com.openthinks.woms.rest.Message.FAILURE);

			return INTERNAL_SERVER_ERROR;
		}

	}

	@Override
	public HttpHeaders create() {
		try {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			long senderId = (Long) session.get("id");

			model = messageService.create(model.getContent(), senderId, model
					.getReceiver().getId());

			msg = new com.openthinks.woms.rest.Message(
					com.openthinks.woms.rest.Message.SUCCESS);

			return new DefaultHttpHeaders("success").setLocationId(model
					.getId());
		} catch (Exception e) {
			logger.debug(e);

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
