package com.openthinks.woms.report.service;

import com.openthinks.woms.report.ColorReport;

public interface ColorReportService {

	/**
	 * Generates ordering report of color.
	 * 
	 * @param accountId
	 * @return
	 */
	ColorReport analyzeColor(String accountId, String brand) throws Exception;
}
