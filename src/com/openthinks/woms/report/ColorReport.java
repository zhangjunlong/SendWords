package com.openthinks.woms.report;

import java.util.Collection;

import com.openthinks.woms.account.Account;

/**
 * Model of color reporting
 * 
 * @author Zhang Junlong
 * 
 */
public class ColorReport {
	private Account account;

	private Collection<ColorReportItem> ColorReportItems;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Collection<ColorReportItem> getColorReportItems() {
		return ColorReportItems;
	}

	public void setColorReportItems(Collection<ColorReportItem> colorReportItems) {
		ColorReportItems = colorReportItems;
	}

}
