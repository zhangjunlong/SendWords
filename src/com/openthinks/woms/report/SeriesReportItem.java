package com.openthinks.woms.report;

/**
 * Type reporting model
 * 
 * @author Zhang Junlong
 * 
 */
public class SeriesReportItem {
	private int seriesId;

	private String seriesName;

	private long quantity;

	private double amount;

	private double quantityPercentage;

	private double amountPercentage;

	public SeriesReportItem() {
		super();
	}

	public SeriesReportItem(int seriesId, String seriesName, long quantity,
			double amount) {
		super();
		this.seriesId = seriesId;
		this.seriesName = seriesName;
		this.quantity = quantity;
		this.amount = amount;
	}

	public int getSeriesId() {
		return seriesId;
	}

	public void setSeriesId(int seriesId) {
		this.seriesId = seriesId;
	}

	public String getSeriesName() {
		return seriesName;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long numbers) {
		this.quantity = numbers;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getQuantityPercentage() {
		return quantityPercentage;
	}

	public void setQuantityPercentage(double numberPercentage) {
		this.quantityPercentage = numberPercentage;
	}

	public double getAmountPercentage() {
		return amountPercentage;
	}

	public void setAmountPercentage(double amountPercentage) {
		this.amountPercentage = amountPercentage;
	}

}
