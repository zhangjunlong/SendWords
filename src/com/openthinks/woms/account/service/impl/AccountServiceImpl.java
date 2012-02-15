package com.openthinks.woms.account.service.impl;

import java.util.Collection;
import java.util.List;

import com.openthinks.woms.account.Account;
import com.openthinks.woms.account.OrderTask;
import com.openthinks.woms.account.dao.AccountDao;
import com.openthinks.woms.account.dao.OrderTaskDao;
import com.openthinks.woms.account.service.AccountService;

public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;

	private OrderTaskDao orderTaskDao;

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public void setOrderTaskDao(OrderTaskDao orderTaskDao) {
		this.orderTaskDao = orderTaskDao;
	}

	public Account find(int id) throws Exception {
		return accountDao.read(id);
	}

	@Override
	public Account find(String userId) throws Exception {
		return accountDao.read(userId);
	}

	@Override
	public Account authorize(String userId, String password) throws Exception {
		Account account = accountDao.read(userId);
		if (account != null) {
			if (password.equals(account.getPassword())) {
				return account;
			}
		}
		return null;
	}

	public Collection<Account> find() throws Exception {
		return accountDao.read();

	}

	public void create(Account account) throws Exception {
		accountDao.create(account);
	}

	public void addOrderTask(OrderTask orderTask) throws Exception {
		orderTaskDao.create(orderTask);
	}

	public void update(Account account) throws Exception {
		accountDao.update(account);
	}

	@Override
	public void delete(int id) throws Exception {
		Account persistedAccount = accountDao.read(id);
		accountDao.delete(persistedAccount);
	}

	@Override
	public List<Object> accountTask(int accountId) throws Exception {
		return this.orderTaskDao.accountTask(accountId);
	}
}
