package com.openthinks.woms.report;

import java.util.ArrayList;
import java.util.List;

import com.openthinks.woms.account.Account;

public class BrandBigtypeReport {
	private Account account;

	private String brand;

	private List<BrandBigtypeReportItem> brandBigtypeReportItems = new ArrayList<BrandBigtypeReportItem>();

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public List<BrandBigtypeReportItem> getBrandBigtypeReportItems() {
		return brandBigtypeReportItems;
	}

	public void setBrandBigtypeReportItems(
			List<BrandBigtypeReportItem> brandBigtypeReportItems) {
		this.brandBigtypeReportItems = brandBigtypeReportItems;
	}
}
