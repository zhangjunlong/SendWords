package com.openthinks.woms.report.dao;

import java.util.Collection;

import com.openthinks.dao.GenericDao;
import com.openthinks.woms.report.SeriesReportItem;

public class SeriesReportDaoJpaImpl implements SeriesReportDao {

	private GenericDao<SeriesReportItem, String> genericDao;

	public void setGenericDao(GenericDao<SeriesReportItem, String> genericDao) {
		this.genericDao = genericDao;
	}

	public Collection<SeriesReportItem> countSeries(String accountId,
			String brand) throws Exception {
		String ql = "SELECT new com.openthinks.woms.report.SeriesReportItem(o.product.series.id, o.product.series.name, SUM(o.quantity), SUM(o.product.orderingPrice*o.quantity)) FROM OrderForm o WHERE o.account.userId LIKE ?0 AND product.brand.text LIKE ?1 GROUP BY o.product.series.id, o.product.series.name";

		return genericDao.query(ql, accountId, brand);
	}
}
