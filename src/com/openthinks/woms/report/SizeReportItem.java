package com.openthinks.woms.report;

import com.openthinks.woms.product.Size;

/**
 * A single item in a size report
 * 
 * @author Zhang Junlong
 * 
 */
public class SizeReportItem {
	private Size size;
	private long quantity;
	private double quantityRatio;
	private double amount;
	private double amountRatio;
	private String candidate;
	private String candidateId;

	public SizeReportItem() {
		super();
		size = new Size();
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
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

	public double getQuantityRatio() {
		return quantityRatio;
	}

	public void setQuantityRatio(double quantityPercentage) {
		this.quantityRatio = quantityPercentage;
	}

	public double getAmountRatio() {
		return amountRatio;
	}

	public void setAmountRatio(double amountPercentage) {
		this.amountRatio = amountPercentage;
	}

	public String getCandidate() {
		return candidate;
	}

	public void setCandidate(String candidate) {
		this.candidate = candidate;
	}

	public String getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}

}
