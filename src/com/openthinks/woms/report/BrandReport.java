package com.openthinks.woms.report;

import java.util.List;

import com.openthinks.woms.account.Account;

public class BrandReport {
	private Account account;

	private List<BrandReportItem> brandReportItems;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<BrandReportItem> getBrandReportItems() {
		return brandReportItems;
	}

	public void setBrandReportItems(List<BrandReportItem> brandReportItems) {
		this.brandReportItems = brandReportItems;
	}
}
