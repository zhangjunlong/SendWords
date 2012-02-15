package com.openthinks.woms.order.rest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;

import com.openthinks.woms.order.OrderModel;
import com.openthinks.woms.order.service.OrderService;
import com.openthinks.woms.product.service.ProductService;
import com.openthinks.woms.product.service.SeasonService;
import com.openthinks.woms.product.service.StyleService;
import com.openthinks.woms.rest.GenericRestfulController;

/**
 * 订购业务主控制器
 * 
 * Restful 请求方式
 * 
 * @author Zhang Wenlong
 * 
 */
@Results({ @Result(name = "success", type = "redirectAction", params = {
		"actionName", "order" }) })
public class OrderController extends GenericRestfulController {

	/**
	 * Default serial version UID
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private OrderModel model = new OrderModel();

	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderService orderService;

    @Autowired
    private StyleService styleService;
    
    @Autowired
    private SeasonService seasonService;
	
	public void setId(String id) {
		this.id = id;
	}

	public HttpHeaders show() {
		try {
			model.setProduct(productService.find(model.getProduct().getId()));
			model.setOrders(orderService.readProductOrderByAccountId(id, model.getProduct().getId()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new DefaultHttpHeaders("show");
	}

	public HttpHeaders index() {
		return new DefaultHttpHeaders("index");
	}

	public HttpHeaders searchProductByKeyword(){
		try {
			if(StringUtils.isNotEmpty(model.getQuerySearchType())){
				model.setStyles(styleService.find());
				model.setSeasons(seasonService.find());
			}
			model.setProducts(productService.find(id,
					model.getNotepadKeyword(), model.getProductSeason(),
					model.getProductStyle(), model.getOrderType(),
					model.getSize(), model.getSection()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new DefaultHttpHeaders("success").setLocationId(model.getClass());
	}
	
	@Override
	public HttpHeaders create() {
		try {
			orderService.create(model.getOrders());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new DefaultHttpHeaders("success").setLocationId(model.getClass());
	}

	@Override
	public String update() {
		return null;
	}

	@Override
	public String destroy() {
	    try {
            orderService.delete(Integer.parseInt(id), model.getProduct().getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "success";
	}
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getModel() {
		if (message != null)
			return message;
		else
			return model;
	}
}
