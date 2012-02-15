package com.openthinks.woms.product.rest;

import java.util.Collection;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.openthinks.woms.product.Brand;
import com.openthinks.woms.product.service.BrandService;
import com.openthinks.woms.rest.GenericRestfulController;
import com.openthinks.woms.rest.Message;

@Results({ @Result(name = "success", type = "redirectAction", params = {
		"actionName", "brand" }) })
public class BrandController extends GenericRestfulController {

	/**
	 * Serial versionUID
	 */
	private static final long serialVersionUID = 1L;

	private BrandService brandService;

	private int id;

	private Brand model = new Brand();

	private Collection<Brand> list;

	public void setBrandService(BrandService brandService) {
		this.brandService = brandService;
	}

	public HttpHeaders create() {
		try {
			brandService.create(model);

			addActionMessage("New brand created successfully");
		} catch (Exception e) {
			e.printStackTrace();
			addFieldError("clientName", "The client name is empty");

			message = new Message(Message.FAILURE, e.getMessage());
		}

		return new DefaultHttpHeaders("success").setLocationId(model.getText());
	}

	public HttpHeaders show() {
		try {
			model = brandService.find(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new DefaultHttpHeaders("show");
	}

	@Override
	public HttpHeaders index() {
		try {
			list = brandService.find();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new DefaultHttpHeaders("index").disableCaching();
	}

	@Override
	public String update() {
		try {
			brandService.update(model);

			addActionMessage("Order updated successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "success";
	}

	@Override
	public String destroy() {
		try {
			brandService.delete(id);
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

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub

	}

}
