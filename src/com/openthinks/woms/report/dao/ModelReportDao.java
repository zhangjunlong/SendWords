package com.openthinks.woms.report.dao;

import java.util.Collection;

import com.openthinks.woms.report.ModelReportByAccountItem;

public interface ModelReportDao {

	Collection<ModelReportByAccountItem> countModeByAccount(String accountId)
			throws Exception;

}
