package com.openthinks.woms.report.service;

import java.math.BigDecimal;
import java.util.Collection;

import com.openthinks.woms.report.SeriesReport;
import com.openthinks.woms.report.SeriesReportItem;
import com.openthinks.woms.report.dao.SeriesReportDao;

public class SeriesReportServiceImpl implements SeriesReportService {

	private SeriesReportDao seriesReportDao;

	public void setSeriesReportDao(SeriesReportDao seriesReportDao) {
		this.seriesReportDao = seriesReportDao;
	}

	@Override
	public SeriesReport analyzeSeries(String accountId, String brand)
			throws Exception {
		SeriesReport seriesReport = new SeriesReport();

		Collection<SeriesReportItem> items = seriesReportDao.countSeries(
				accountId, brand);

		seriesReport.setSeriesReportItems(items);

		int amountSum = 0;
		int quantitySum = 0;
		for (SeriesReportItem item : items) {
			amountSum += item.getAmount();
			quantitySum += item.getQuantity();
		}

		BigDecimal hundred = new BigDecimal("100");

		for (SeriesReportItem item : items) {
			item.setQuantityPercentage(new BigDecimal(item.getQuantity())
					.divide(new BigDecimal(quantitySum), 3,
							BigDecimal.ROUND_HALF_UP).multiply(hundred)
					.doubleValue());
			item.setAmountPercentage(new BigDecimal(item.getAmount())
					.divide(new BigDecimal(amountSum), 3,
							BigDecimal.ROUND_HALF_UP).multiply(hundred)
					.doubleValue());
		}

		return seriesReport;
	}

}
