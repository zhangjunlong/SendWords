package com.openthinks.woms.report.service;

import java.math.BigDecimal;
import java.util.Collection;

import com.openthinks.woms.report.SeasonReport;
import com.openthinks.woms.report.SeasonReportItem;
import com.openthinks.woms.report.dao.SeasonReportDao;

public class SeasonReportServiceImpl implements SeasonReportService {

	private SeasonReportDao seasonReportDao;

	public void setSeasonReportDao(SeasonReportDao seasonReportDao) {
		this.seasonReportDao = seasonReportDao;
	}

	@Override
	public SeasonReport analyzeSeason(String accountId, String brand)
			throws Exception {
		SeasonReport seasonReport = new SeasonReport();
		Collection<SeasonReportItem> items = seasonReportDao.countSeason(
				accountId, brand);

		seasonReport.setSeasonReportItems(items);

		int amountSum = 0;
		int quantitySum = 0;
		for (SeasonReportItem item : items) {
			amountSum += item.getAmount();
			quantitySum += item.getQuantity();
		}

		BigDecimal hundred = new BigDecimal("100");

		for (SeasonReportItem item : items) {
			item.setQuantityPercentage(new BigDecimal(item.getQuantity())
					.divide(new BigDecimal(quantitySum), 3,
							BigDecimal.ROUND_HALF_UP).multiply(hundred)
					.doubleValue());
			item.setAmountPercentage(new BigDecimal(item.getAmount())
					.divide(new BigDecimal(amountSum), 3,
							BigDecimal.ROUND_HALF_UP).multiply(hundred)
					.doubleValue());
		}

		return seasonReport;
	}

}
