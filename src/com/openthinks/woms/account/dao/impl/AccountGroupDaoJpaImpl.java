package com.openthinks.woms.account.dao.impl;

import java.util.Collection;

import com.openthinks.dao.GenericJpaDaoBean;
import com.openthinks.woms.account.AccountGroup;
import com.openthinks.woms.account.dao.AccountGroupDao;

/**
 * A implementation of JPA data access for account group
 * 
 * @author Zhang Junlong
 * 
 */
public class AccountGroupDaoJpaImpl extends
		GenericJpaDaoBean<AccountGroup, Integer> implements AccountGroupDao {

	public AccountGroupDaoJpaImpl() throws Exception {
		super(AccountGroup.class);
	}

	@Override
	public Collection<AccountGroup> read() throws Exception {
		String ql = "select ag from AccountGroup ag";
		return readSpecifiedSection(ql, 0, 1).getResultList();
	}
}
