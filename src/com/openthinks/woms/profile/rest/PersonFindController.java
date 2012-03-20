package com.openthinks.woms.profile.rest;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.openthinks.woms.profile.service.SimplifiedPersonService;
import com.openthinks.woms.rest.GenericRestfulQueryController;
import com.openthinks.woms.rest.Message;

/**
 * Product finding controller
 * 
 * @author Zhang Junlong
 * 
 */
@Results({ @Result(name = "success", type = "redirectAction", params = {
		"actionName", "personFind" }) })
public class PersonFindController extends GenericRestfulQueryController {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Object model = new SimplyQuery();

	private SimplifiedPersonService simplifiedProductService;

	public void setSimplifiedProductService(
			SimplifiedPersonService simplifiedProductService) {
		this.simplifiedProductService = simplifiedProductService;
	}

	@Override
	public Object getModel() {
		return model;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
	}

	@Override
	public String find() {
		SimplyQuery sq = (SimplyQuery) model;
		try {
			model = simplifiedProductService.find(sq.getKeywords(),
					sq.getPageSize(), sq.getPage());
		} catch (Exception e) {
			e.printStackTrace();
			model = new Message(Message.FAILURE, e.getMessage());
		}

		return "success";
	}
}
