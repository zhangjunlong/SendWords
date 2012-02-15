package com.openthinks.woms.report;

import java.util.ArrayList;
import java.util.List;

import com.openthinks.woms.account.Account;

public class SeasonCategoryReport {
	private Account account;

	private String season;

	private List<SeasonCategoryReportItem> seasonCategoryReportItems = new ArrayList<SeasonCategoryReportItem>();

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public List<SeasonCategoryReportItem> getSeasonCategoryReportItems() {
		return seasonCategoryReportItems;
	}

	public void setSeasonCategoryReportItems(
			List<SeasonCategoryReportItem> seasonCategoryReportItems) {
		this.seasonCategoryReportItems = seasonCategoryReportItems;
	}

}
