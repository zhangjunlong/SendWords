package com.openthinks.woms.report.service;

import com.openthinks.woms.report.CategoryReport;

public interface CategoryReportService {

	/**
	 * Generates ordering report of color.
	 * 
	 * @param accountId
	 * @return
	 */
	CategoryReport analyzeCategory(String accountId, String brand) throws Exception;
}
