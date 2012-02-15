package com.openthinks.woms.report;

/**
 * Model of a quantity with category info
 * 
 * @author Zhang Junlong
 * 
 */
public class QuantityByCategory {

	private String bigtype;

	private String category;

	private long quantity;

	private double percentage = 0;

	public String getBigtype() {
		return bigtype;
	}

	public void setBigtype(String bigtype) {
		this.bigtype = bigtype;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

}