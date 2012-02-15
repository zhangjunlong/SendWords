package com.openthinks.woms.report;

import java.util.Collection;
import java.util.Collection;

import com.openthinks.woms.account.Account;

/**
 * Model of a season report.
 * 
 * @author Zhang Junlong
 * 
 */
public class SeasonReport {
	private Account account;
	private Collection<SeasonReportItem> seasonReportItems;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Collection<SeasonReportItem> getSeasonReportItems() {
		return seasonReportItems;
	}

	public void setSeasonReportItems(Collection<SeasonReportItem> seasonReportItems) {
		this.seasonReportItems = seasonReportItems;
	}

}
