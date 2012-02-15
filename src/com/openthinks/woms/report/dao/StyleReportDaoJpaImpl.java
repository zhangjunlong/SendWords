package com.openthinks.woms.report.dao;

import java.util.Collection;

import com.openthinks.dao.GenericDao;
import com.openthinks.woms.report.StyleReportItem;

public class StyleReportDaoJpaImpl implements StyleReportDao {

	private GenericDao<StyleReportItem, String> genericDao;

	public void setGenericDao(GenericDao<StyleReportItem, String> genericDao) {
		this.genericDao = genericDao;
	}

	@Override
	public Collection<StyleReportItem> countStyle(String accountId, String brand)
			throws Exception {
		String ql = "SELECT new com.openthinks.woms.report.StyleReportItem(o.product.style.id, o.product.style.name,SUM(o.quantity),SUM(o.product.orderingPrice*o.quantity)) FROM OrderForm o WHERE o.account.userId LIKE ?0 AND product.brand.text LIKE ?1 GROUP BY product.style.id";

		return genericDao.query(ql, accountId, brand);
	}
}
