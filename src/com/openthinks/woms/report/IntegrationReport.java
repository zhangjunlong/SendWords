package com.openthinks.woms.report;

import java.util.List;

/**
 * Model of a integration report
 * 
 * @author Zhang Junlong
 * 
 */
public class IntegrationReport {

	private List<QuantityByCategory> categorySumList;
	private double targetAmount;
	private double totalAmount;
	private double quantityOCount;
	private double quantitySCount;
	private double quantityMCount;
	private double quantityLCount;
	private double quantityXLCount;
	private double quantityXXLCount;
	private long quantityCount;

	public List<QuantityByCategory> getCategorySumList() {
		return categorySumList;
	}

	public void setCategorySumList(List<QuantityByCategory> categorySumList) {
		this.categorySumList = categorySumList;
	}

	public double getTargetAmount() {
		return targetAmount;
	}

	public void setTargetAmount(double targetAmount) {
		this.targetAmount = targetAmount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getQuantityOCount() {
		return quantityOCount;
	}

	public void setQuantityOCount(double quantityOCount) {
		this.quantityOCount = quantityOCount;
	}

	public double getQuantitySCount() {
		return quantitySCount;
	}

	public void setQuantitySCount(double quantitySCount) {
		this.quantitySCount = quantitySCount;
	}

	public double getQuantityMCount() {
		return quantityMCount;
	}

	public void setQuantityMCount(double quantityMCount) {
		this.quantityMCount = quantityMCount;
	}

	public double getQuantityLCount() {
		return quantityLCount;
	}

	public void setQuantityLCount(double quantityLCount) {
		this.quantityLCount = quantityLCount;
	}

	public double getQuantityXLCount() {
		return quantityXLCount;
	}

	public void setQuantityXLCount(double quantityXLCount) {
		this.quantityXLCount = quantityXLCount;
	}

	public double getQuantityXXLCount() {
		return quantityXXLCount;
	}

	public void setQuantityXXLCount(double quantityXXLCount) {
		this.quantityXXLCount = quantityXXLCount;
	}

	public long getQuantityCount() {
		return quantityCount;
	}

	public void setQuantityCount(long quantityCount) {
		this.quantityCount = quantityCount;
	}

}
