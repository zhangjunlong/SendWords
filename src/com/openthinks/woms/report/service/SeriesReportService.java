package com.openthinks.woms.report.service;

import com.openthinks.woms.report.SeriesReport;

public interface SeriesReportService {
	/**
	 * Generate a category report
	 * 
	 * @param string
	 * @return
	 */
	SeriesReport analyzeSeries(String account, String brand) throws Exception;

}
