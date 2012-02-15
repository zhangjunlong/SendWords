package com.openthinks.woms.report.service;

import java.util.Collection;

import com.openthinks.woms.report.ModelReportByAccountItem;

public interface ModelReportService {
	Collection<ModelReportByAccountItem> analyzeModelByAccount(String account)
			throws Exception;
}
