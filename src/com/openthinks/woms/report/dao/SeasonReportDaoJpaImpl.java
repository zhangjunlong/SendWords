package com.openthinks.woms.report.dao;

import java.util.Collection;

import com.openthinks.dao.GenericDao;
import com.openthinks.woms.report.SeasonReportItem;

public class SeasonReportDaoJpaImpl implements SeasonReportDao {

	private GenericDao<SeasonReportItem, String> genericDao;

	public void setGenericDao(GenericDao<SeasonReportItem, String> genericDao) {
		this.genericDao = genericDao;
	}

	@Override
	public Collection<SeasonReportItem> countSeason(String accountId,
			String brand) throws Exception {
		String ql = "SELECT new com.openthinks.woms.report.SeasonReportItem(o.product.season,SUM(o.quantity),SUM(o.product.orderingPrice*o.quantity)) FROM OrderForm o WHERE o.account.userId LIKE ?0 AND o.product.brand.text LIKE ?1 GROUP BY o.product.season";

		return genericDao.query(ql, accountId, brand);
	}

}
