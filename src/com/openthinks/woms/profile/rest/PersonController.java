package com.openthinks.woms.profile.rest;

import java.util.Collection;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;

import com.openthinks.woms.profile.Person;
import com.openthinks.woms.profile.service.PersonService;
import com.openthinks.woms.rest.GenericRestfulController;

/**
 * Controller for view of products
 * 
 * @author Zhang Junlong
 * 
 */
@Results({ @Result(name = "success", type = "redirectAction", params = {
		"actionName", "person" }) })
public class PersonController extends GenericRestfulController {

	/**
	 * Default serial version UID
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private Person model = new Person();

	private Collection<Person> list;

	@Autowired
	private PersonService personService;

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub

	}

	public HttpHeaders show() {
		try {
			model = personService.find(model.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new DefaultHttpHeaders("show");
	}

	public HttpHeaders index() {

		try {
			list = personService.find();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new DefaultHttpHeaders("index").disableCaching();
	}

	@Override
	public HttpHeaders create() {
		try {
			personService.create(model);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new DefaultHttpHeaders("success").setLocationId(model.getId());
	}

	@Override
	public String update() {
		try {
			personService.update(model);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "success";
	}

	@Override
	public String destroy() {

		try {
			personService.delete(model.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "success";
	}

	@Override
	public Object getModel() {
		if (message != null)
			return message;
		else
			return (list != null ? list : model);
	}

}
