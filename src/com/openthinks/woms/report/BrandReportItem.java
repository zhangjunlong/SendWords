package com.openthinks.woms.report;

public class BrandReportItem {

	private String brand;

	private long quantity;

	private double amount;

	private double quantityPercentage = 0;

	private double amountPercentage = 0;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
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
