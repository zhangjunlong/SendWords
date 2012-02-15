package com.openthinks.woms.report;

import java.util.Collection;

import com.openthinks.woms.account.Account;

/**
 * Model of a size report
 * 
 * @author Zhang Junlong
 * 
 */
public class SizeReport {
	private Account account;

	private Collection<SizeReportItem> sizeReportItems;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Collection<SizeReportItem> getSizeReportItems() {
		return sizeReportItems;
	}

	public void setSizeReportItems(Collection<SizeReportItem> sizeReportItems) {
		this.sizeReportItems = sizeReportItems;
	}

}
