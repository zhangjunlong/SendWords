package com.openthinks.woms.order.dao;

import java.util.List;

import com.openthinks.dao.GenericDao;
import com.openthinks.woms.order.OrderForm;

public interface OrderDao extends GenericDao<OrderForm, Long> {
    
    List<OrderForm> readProductOrderByAccountId(String accountId,long productId) throws Exception;
    
	void create(OrderForm order) throws Exception;
	
	void delete(int accountId,long productId) throws Exception;

    List<OrderForm> read(String accountId) throws Exception;
}
