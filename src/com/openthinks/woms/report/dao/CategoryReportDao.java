package com.openthinks.woms.report.dao;

import java.util.Collection;

import com.openthinks.woms.report.CategoryReportItem;

public interface CategoryReportDao {
	/**
	 * Count summary of different color
	 * 
	 * @param accountId
	 * @return
	 */
	Collection<CategoryReportItem> countCategory(String accountId, String brand)
			throws Exception;
}
