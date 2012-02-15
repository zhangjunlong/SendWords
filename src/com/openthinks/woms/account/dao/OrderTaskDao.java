package com.openthinks.woms.account.dao;

import java.util.List;

import com.openthinks.dao.GenericDao;
import com.openthinks.woms.account.OrderTask;

/**
 * Data access interface for account
 * 
 * @author Zhang Junlong
 * 
 */
public interface OrderTaskDao extends GenericDao<OrderTask, Long> {
	List<Object> accountTask(int accountId) throws Exception;
}