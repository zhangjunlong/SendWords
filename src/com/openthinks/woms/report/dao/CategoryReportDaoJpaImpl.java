package com.openthinks.woms.report.dao;

import java.util.Collection;

import com.openthinks.dao.GenericDao;
import com.openthinks.woms.report.CategoryReportItem;

public class CategoryReportDaoJpaImpl implements CategoryReportDao {

	private GenericDao<CategoryReportItem, String> genericDao;

	public void setGenericDao(GenericDao<CategoryReportItem, String> genericDao) {
		this.genericDao = genericDao;
	}

	@Override
	public Collection<CategoryReportItem> countCategory(String accountId,
			String brand) throws Exception {
		String ql = "SELECT new com.openthinks.woms.report.CategoryReportItem ( o.product.category.id, o.product.category.name, SUM(o.quantity), SUM(o.product.orderingPrice*o.quantity) )FROM OrderForm o WHERE o.account.userId LIKE ?0 AND o.product.brand.text LIKE ?1 GROUP BY o.product.category.id";

		return genericDao.query(ql, accountId, brand);
	}
}
