package com.openthinks.woms.report.dao;

import java.util.Collection;

import com.openthinks.woms.report.ColorReportItem;

public interface ColorReportDao {
	/**
	 * Count summary of different color
	 * 
	 * @param accountId
	 * @return
	 */
	Collection<ColorReportItem> countColor(String accountId, String brand)
			throws Exception;
}
