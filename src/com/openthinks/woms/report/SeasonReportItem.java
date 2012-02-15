package com.openthinks.woms.report;

/**
 * A single item in a season report item.
 * 
 * @author Zhang Junlong
 * 
 */
public class SeasonReportItem {
	private String season;
	private long quantity;
	private double amount;
	private double quantityPercentage;
	private double amountPercentage;

	public SeasonReportItem() {
		super();
	}

	public SeasonReportItem(String season, long quantity, double amount) {
		super();
		this.season = season;
		this.quantity = quantity;
		this.amount = amount;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
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

	public void setQuantityPercentage(double quantityPercentage) {
		this.quantityPercentage = quantityPercentage;
	}

	public double getAmountPercentage() {
		return amountPercentage;
	}

	public void setAmountPercentage(double amountPercentage) {
		this.amountPercentage = amountPercentage;
	}

}
