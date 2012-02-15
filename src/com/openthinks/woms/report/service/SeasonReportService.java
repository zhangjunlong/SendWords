package com.openthinks.woms.report.service;

import com.openthinks.woms.report.SeasonReport;

public interface SeasonReportService {
	/**
	 * Generate ordering report of season.
	 * 
	 * @param accountId
	 * @return
	 */
	SeasonReport analyzeSeason(String accountId, String brand) throws Exception;

}
