package com.openthinks.woms.account;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 * Account
 * 
 * @author Zhang Junlong
 * 
 */
@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(unique = true)
	private String userId;

	private String name;

	private String description;

	private String password;

	private String targetAmount;

	@Column(length = 20)
	private String role;

	@ManyToOne
	private AccountGroup accountGroup;

	@Transient
	private List<Object> statisticsTask;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public AccountGroup getAccountGroup() {
		return accountGroup;
	}

	public void setAccountGroup(AccountGroup accountGroup) {
		this.accountGroup = accountGroup;
	}

	public String getTargetAmount() {
		return targetAmount;
	}

	public void setTargetAmount(String targetAmount) {
		this.targetAmount = targetAmount;
	}

	public List<Object> getStatisticsTask() {
		return statisticsTask;
	}

	public void setStatisticsTask(List<Object> statisticsTask) {
		this.statisticsTask = statisticsTask;
	}

}
