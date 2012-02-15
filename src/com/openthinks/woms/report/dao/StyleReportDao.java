package com.openthinks.woms.report.dao;

import java.util.Collection;

import com.openthinks.woms.report.StyleReportItem;

public interface StyleReportDao {
	/**
	 * Count summary of styles
	 * 
	 * @param accountId
	 */
	Collection<StyleReportItem> countStyle(String accountId, String brand)
			throws Exception;
}
