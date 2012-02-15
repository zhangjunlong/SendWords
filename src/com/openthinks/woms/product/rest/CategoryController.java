package com.openthinks.woms.product.rest;

import java.util.Collection;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;

import com.openthinks.woms.product.Category;
import com.openthinks.woms.product.service.CategoryService;
import com.openthinks.woms.rest.GenericRestfulController;
import com.openthinks.woms.rest.Message;

@Results({ @Result(name = "success", type = "redirectAction", params = {
		"actionName", "category" }) })
public class CategoryController extends GenericRestfulController {

	/**
	 * Serial versionUID
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private CategoryService categoryService;

	private String id;

	private Category model = new Category();

	private Collection<Category> list;

	public HttpHeaders create() {
		try {
			categoryService.create(model);

			addActionMessage("New brand created successfully");
		} catch (Exception e) {
			e.printStackTrace();
			addFieldError("clientName", "The client name is empty");

			message = new Message(Message.FAILURE, e.getMessage());
		}

		return new DefaultHttpHeaders("success").setLocation(String
				.valueOf(model.getId()));
	}

	public HttpHeaders show() {
		try {
			model = categoryService.find(Integer.parseInt(id));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new DefaultHttpHeaders("show");
	}

	@Override
	public HttpHeaders index() {
		try {
			list = categoryService.find();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new DefaultHttpHeaders("index").disableCaching();
	}

	@Override
	public String update() {
		try {
			if (null != model.getParentCategory()) {
				if (model.getParentCategory().getId() == 0) {
					model.setParentCategory(null);
				}
			}
			categoryService.update(model);

			addActionMessage("Order updated successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "success";
	}

	@Override
	public String destroy() {
		try {
			categoryService.delete(Integer.parseInt(id));
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
