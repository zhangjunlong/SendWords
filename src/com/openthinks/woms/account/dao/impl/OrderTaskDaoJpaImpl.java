package com.openthinks.woms.account.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.openthinks.dao.GenericJpaDaoBean;
import com.openthinks.woms.account.OrderTask;
import com.openthinks.woms.account.dao.OrderTaskDao;

/**
 * A implementation of JPA data access for account
 *  
 * @author Zhang Junlong
 *
 */
public class OrderTaskDaoJpaImpl extends GenericJpaDaoBean<OrderTask,Long> implements OrderTaskDao{

	public OrderTaskDaoJpaImpl() {
		super(OrderTask.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> accountTask(int accountId){
		String ql = "select count(DISTINCT o.product.category.id),sum(o.quantity),sum(o.quantity*o.product.orderingPrice) " +
				"from OrderForm o where o.account.id= ?";
		
        Query query = em.createQuery(ql);
        query.setParameter(1, accountId);
        
        return query.getResultList();
	}
}
