package com.openthinks.woms.report;

/**
 * Style reporting model
 * 
 * @author Zhang Junlong
 * 
 */
public class StyleReportItem {
	private int styleId;

	private String styleName;

	private long quantity;

	private double amount;

	private double quantityPercentage;

	private double amountPercentage;

	public StyleReportItem() {
		super();
	}

	public StyleReportItem(int id, String style, long numbers, double amount) {
		super();
		this.styleId = id;
		this.styleName = style;
		this.quantity = numbers;
		this.amount = amount;
	}

	public String getStyleName() {
		return styleName;
	}

	public void setStyleName(String style) {
		this.styleName = style;
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
