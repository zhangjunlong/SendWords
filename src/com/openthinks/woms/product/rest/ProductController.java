package com.openthinks.woms.product.rest;

import java.util.Collection;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;

import com.openthinks.woms.product.Product;
import com.openthinks.woms.product.service.ProductService;
import com.openthinks.woms.rest.GenericRestfulController;

/**
 * Controller for view of products
 * 
 * @author Zhang Junlong
 * 
 */
@Results({ @Result(name = "success", type = "redirectAction", params = {
		"actionName", "product" }) })
public class ProductController extends GenericRestfulController {

	/**
	 * Default serial version UID
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private Product model = new Product();

	private Collection<Product> list;

	@Autowired
	private ProductService productService;

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub

	}

	public HttpHeaders show() {
		try {
			model = productService.find(model.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new DefaultHttpHeaders("show");
	}

	public HttpHeaders index() {

		try {
			list = productService.find();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new DefaultHttpHeaders("index").disableCaching();
	}

	@Override
	public HttpHeaders create() {
		try {
			model.setMatchProduct(null);
			productService.create(model);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new DefaultHttpHeaders("success").setLocationId(model.getId());
	}

	@Override
	public String update() {
		try {
			model.setMatchProduct(null);
			productService.update(model);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "success";
	}

	@Override
	public String destroy() {

		try {
			productService.delete(model.getId());
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
