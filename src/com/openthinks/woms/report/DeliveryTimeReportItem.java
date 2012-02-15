package com.openthinks.woms.report;

/**
 * A single item in a delivery time report
 * 
 * @author Zhang Junlong
 * 
 */
public class DeliveryTimeReportItem {

	private String deliveryTime;

	private long totalStyle;

	private long totalStyleOrdered;

	private long totalProduct;

	private long totalProductOrdered;

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public long getTotalStyle() {
		return totalStyle;
	}

	public void setTotalStyle(long totalStyle) {
		this.totalStyle = totalStyle;
	}

	public long getTotalStyleOrdered() {
		return totalStyleOrdered;
	}

	public void setTotalStyleOrdered(long totalStyleOrdered) {
		this.totalStyleOrdered = totalStyleOrdered;
	}

	public long getTotalProduct() {
		return totalProduct;
	}

	public void setTotalProduct(long totalProduct) {
		this.totalProduct = totalProduct;
	}

	public long getTotalProductOrdered() {
		return totalProductOrdered;
	}

	public void setTotalProductOrdered(long totalProductOrdered) {
		this.totalProductOrdered = totalProductOrdered;
	}

}
