package com.openthinks.woms.report.service;

import java.math.BigDecimal;
import java.util.Collection;

import com.openthinks.woms.report.CategoryReport;
import com.openthinks.woms.report.CategoryReportItem;
import com.openthinks.woms.report.dao.CategoryReportDao;

public class CategoryReportServiceImpl implements CategoryReportService {

	private CategoryReportDao colorReportDao;

	public void setCategoryReportDao(CategoryReportDao colorReportDao) {
		this.colorReportDao = colorReportDao;
	}

	@Override
	public CategoryReport analyzeCategory(String accountId, String brand)
			throws Exception {
		CategoryReport colorReport = new CategoryReport();
		Collection<CategoryReportItem> items = colorReportDao.countCategory(accountId,
				brand);

		colorReport.setCategoryReportItems(items);

		int amountSum = 0;
		int quantitySum = 0;
		for (CategoryReportItem item : items) {
			amountSum += item.getAmount();
			quantitySum += item.getQuantity();
		}

		BigDecimal hundred = new BigDecimal("100");

		for (CategoryReportItem item : items) {
			item.setQuantityPercentage(new BigDecimal(item.getQuantity())
					.divide(new BigDecimal(quantitySum), 3,
							BigDecimal.ROUND_HALF_UP).multiply(hundred)
					.doubleValue());
			item.setAmountPercentage(new BigDecimal(item.getAmount())
					.divide(new BigDecimal(amountSum), 3,
							BigDecimal.ROUND_HALF_UP).multiply(hundred)
					.doubleValue());
		}

		return colorReport;
	}
}
