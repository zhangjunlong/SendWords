package com.openthinks.woms.report.service;

import com.openthinks.woms.report.SizeReport;

public interface SizeReportService {
	SizeReport analyzeSizeByCandidate(String account,
			String candidate) throws Exception;
}
