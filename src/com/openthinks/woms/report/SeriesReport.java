package com.openthinks.woms.report;

import java.util.Collection;

import com.openthinks.woms.account.Account;

/**
 * Model of a series' report
 * 
 * @author Zhang Junlong
 * 
 */
public class SeriesReport {
	private Account account;

	private Collection<SeriesReportItem> seriesReportItems;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Collection<SeriesReportItem> getSeriesReportItems() {
		return seriesReportItems;
	}

	public void setSeriesReportItems(
			Collection<SeriesReportItem> seriesReportItems) {
		this.seriesReportItems = seriesReportItems;
	}

}
