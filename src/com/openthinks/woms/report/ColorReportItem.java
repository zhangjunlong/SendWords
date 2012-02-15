package com.openthinks.woms.report;

/**
 * A single item of color reporting
 * 
 * @author Zhang Junlong
 * 
 */
public class ColorReportItem {
	private String colorCode;
	private String colorName;
	private long quantity;
	private double amount;
	private double quantityPercentage;
	private double amountPercentage;

	public ColorReportItem() {
		super();
	}

	public ColorReportItem(String colorCode, String colorName, long quantity,
			double amount) {
		super();
		this.colorCode = colorCode;
		this.colorName = colorName;
		this.quantity = quantity;
		this.amount = amount;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
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
