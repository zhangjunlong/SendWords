package com.openthinks.woms.report;

public class ModelReportByAccountItem {

	private String accountName;
	private String model;
	private String productName;
	private float price;
	private int colorModelCount;
	private long amount;

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getColorModelCount() {
		return colorModelCount;
	}

	public void setColorModelCount(int colorModelCount) {
		this.colorModelCount = colorModelCount;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

}
