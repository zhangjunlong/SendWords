package com.openthinks.woms.report.dao;

import java.util.Collection;

import com.openthinks.woms.report.SeasonReportItem;

public interface SeasonReportDao {

	/**
	 * Count summary of different season
	 * 
	 * @param accountId
	 * @return
	 */
	Collection<SeasonReportItem> countSeason(String accountId, String brand)
			throws Exception;
}
