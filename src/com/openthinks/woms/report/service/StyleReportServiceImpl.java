package com.openthinks.woms.report.service;

import java.math.BigDecimal;
import java.util.Collection;

import com.openthinks.woms.report.StyleReport;
import com.openthinks.woms.report.StyleReportItem;
import com.openthinks.woms.report.dao.StyleReportDao;

/**
 * Product' style reporting service
 * 
 * @author Zhang Junlong
 * 
 */
public class StyleReportServiceImpl implements StyleReportService {
	private StyleReportDao styleReportDao;

	public void setStyleReportDao(StyleReportDao styleReportDao) {
		this.styleReportDao = styleReportDao;
	}

	@Override
	public StyleReport analyzeStyle(String accountId, String brand)
			throws Exception {
		StyleReport styleReport = new StyleReport();
		Collection<StyleReportItem> items = styleReportDao.countStyle(accountId,
				brand);

		styleReport.setStyleReportItems(items);

		int amountSum = 0;
		int quantitySum = 0;
		for (StyleReportItem item : items) {
			amountSum += item.getAmount();
			quantitySum += item.getQuantity();
		}

		BigDecimal hundred = new BigDecimal("100");

		for (StyleReportItem item : items) {
			item.setQuantityPercentage(new BigDecimal(item.getQuantity())
					.divide(new BigDecimal(quantitySum), 3,
							BigDecimal.ROUND_HALF_UP).multiply(hundred)
					.doubleValue());
			item.setAmountPercentage(new BigDecimal(item.getAmount())
					.divide(new BigDecimal(amountSum), 3,
							BigDecimal.ROUND_HALF_UP).multiply(hundred)
					.doubleValue());
		}

		return styleReport;
	}
}
