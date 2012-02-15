package com.openthinks.woms.account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.openthinks.woms.product.Brand;

/**
 * Task for ordering
 * 
 * @author Zhang Junlong
 * 
 */
@Entity
public class OrderTask {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	private Brand brand;

	private double amount;

	@ManyToOne
	private Account account;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double orderTask) {
		this.amount = orderTask;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
