package com.openthinks.woms.report.service;

import com.openthinks.woms.report.StyleReport;

public interface StyleReportService {

	StyleReport analyzeStyle(String accountId, String brand) throws Exception;

}
