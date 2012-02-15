package com.openthinks.woms.report.dao;

import java.util.Collection;

import com.openthinks.woms.report.SeriesReportItem;

public interface SeriesReportDao {
	Collection<SeriesReportItem> countSeries(String accountId, String brand)
			throws Exception;
}
