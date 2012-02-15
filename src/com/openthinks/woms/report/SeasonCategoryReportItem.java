package com.openthinks.woms.report;

import java.math.BigDecimal;

/**
 * A single item in Season-Category Report
 * 
 * @author Zhang Junlong
 * 
 */
public class SeasonCategoryReportItem {

	private String season;

	private String category;

	private long totalCount;

	private long orderedCount;

	private double percentage;

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public long getOrderedCount() {
		return orderedCount;
	}

	public void setOrderedCount(long orderedCount) {
		this.orderedCount = orderedCount;
	}

	public double getPercentage() {
		BigDecimal oc = new BigDecimal(orderedCount * 100);
		BigDecimal tc = new BigDecimal(totalCount);

		return oc.divide(tc, 1, BigDecimal.ROUND_HALF_UP).longValue();
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
}
