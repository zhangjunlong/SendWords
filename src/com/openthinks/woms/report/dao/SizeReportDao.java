package com.openthinks.woms.report.dao;

import java.util.Collection;

import com.openthinks.woms.report.SizeReportItem;

public interface SizeReportDao {
	Collection<SizeReportItem> countSizeByCandidate(String accountId,
			String candidate);
}
