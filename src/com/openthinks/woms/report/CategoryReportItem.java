package com.openthinks.woms.report;

/**
 * A single item of color reporting
 * 
 * @author Zhang Junlong
 * 
 */
public class CategoryReportItem {
	private int categoryId;
	private String categoryName;
	private long quantity;
	private double amount;
	private double quantityPercentage;
	private double amountPercentage;

	public CategoryReportItem() {
		super();
	}

	public CategoryReportItem(int categoryId, String categoryName,
			long quantity, double amount) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.quantity = quantity;
		this.amount = amount;
	}

	public int getCategoryCode() {
		return categoryId;
	}

	public void setCategoryCode(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String colorName) {
		this.categoryName = colorName;
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
