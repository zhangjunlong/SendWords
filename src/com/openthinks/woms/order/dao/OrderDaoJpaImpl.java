package com.openthinks.woms.order.dao;

import java.util.List;

import javax.persistence.Query;

import com.openthinks.dao.GenericJpaDaoBean;
import com.openthinks.woms.order.OrderForm;

public class OrderDaoJpaImpl extends GenericJpaDaoBean<OrderForm, Long> implements
		OrderDao {

	public OrderDaoJpaImpl() {
		super(OrderForm.class);
	}

	@SuppressWarnings("unchecked")
    @Override
    public List<OrderForm> readProductOrderByAccountId(String accountId,long productId)
            throws Exception {
        String ql = "select new com.openthinks.woms.order.OrderForm(o.id, o.color, o.size, o.quantity) " +
        		"from OrderForm o where o.account.id = ? and o.product.id = ?";
        
        Query query = em.createQuery(ql);
        query.setParameter(1, Integer.parseInt(accountId));
        query.setParameter(2, productId);
        
        return query.getResultList();
    }
	
	@Override
	public void create(OrderForm order) throws Exception {
		super.create(order);
	}

    @Override
    public void delete(int accountId, long productId) throws Exception {
        String ql = "delete from OrderForm o where o.account.id = ? and o.product.id = ?";

        Query query = em.createQuery(ql);
        query.setParameter(1, accountId);
        query.setParameter(2, productId);
        
        query.executeUpdate();
    }

    @Override
    public List<OrderForm> read(String accountId) throws Exception {
        String ql = "select o from OrderForm o where o.account.userId='"+accountId+"' order by o.product.id asc";
        return this.readSpecifiedSection(ql, 0, 1).getResultList();
    }
}
