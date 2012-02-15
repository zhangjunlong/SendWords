package com.openthinks.woms.account.service;

import java.util.Collection;

import com.openthinks.woms.account.AccountGroup;

public interface AccountGroupService {
	void create(AccountGroup group) throws Exception;

	Collection<AccountGroup> find() throws Exception;

	AccountGroup find(int id) throws Exception;

	void update(AccountGroup group) throws Exception;

	void delete(int id) throws Exception;
}
