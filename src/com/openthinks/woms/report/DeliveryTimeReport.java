package com.openthinks.woms.report;

import java.util.List;

import com.openthinks.woms.account.Account;

/**
 * Model of delivery time report
 * 
 * @author Zhang Junlong
 * 
 */
public class DeliveryTimeReport {

	private Account account;

	private List<DeliveryTimeReportItem> deliveryTimeReportItems;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<DeliveryTimeReportItem> getDeliveryTimeReportItems() {
		return deliveryTimeReportItems;
	}

	public void setDeliveryTimeReportItems(
			List<DeliveryTimeReportItem> deliveryTimeReportItems) {
		this.deliveryTimeReportItems = deliveryTimeReportItems;
	}

}
