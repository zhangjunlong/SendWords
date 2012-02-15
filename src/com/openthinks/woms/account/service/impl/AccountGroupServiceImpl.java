package com.openthinks.woms.account.service.impl;

import java.util.Collection;

import com.openthinks.woms.account.AccountGroup;
import com.openthinks.woms.account.dao.AccountGroupDao;
import com.openthinks.woms.account.service.AccountGroupService;

public class AccountGroupServiceImpl implements AccountGroupService {

	private AccountGroupDao accountGroupDao;

	public void setAccountGroupDao(AccountGroupDao accountGroupDao) {
		this.accountGroupDao = accountGroupDao;
	}

	@Override
	public void create(AccountGroup group) throws Exception {
		accountGroupDao.create(group);
	}

	@Override
	public Collection<AccountGroup> find() throws Exception {
		return accountGroupDao.read();
	}

	@Override
	public AccountGroup find(int id) throws Exception {
		return accountGroupDao.read(id);
	}

	@Override
	public void update(AccountGroup group) throws Exception {
		accountGroupDao.update(group);
	}

	@Override
	public void delete(int id) throws Exception {
		AccountGroup ag = accountGroupDao.read(id);
		accountGroupDao.delete(ag);
	}

}
