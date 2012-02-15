package com.openthinks.woms.order.service;

import java.util.List;

import com.openthinks.woms.order.OrderForm;

/**
 * Service interface for ordering
 * 
 * @author Zhang Junlong
 * 
 */
public interface OrderService {
    
    List<OrderForm> readProductOrderByAccountId(String accountId,long productId) throws Exception;
	
	void create(List<OrderForm> orders) throws Exception;

    void delete(int accountId,long productId) throws Exception;
    
    List<OrderForm> read(String accountId) throws Exception;

}
