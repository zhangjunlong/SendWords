package com.openthinks.woms.account.dao;

import java.util.Collection;

import com.openthinks.dao.GenericDao;
import com.openthinks.woms.account.AccountGroup;

/**
 * Data access interface for account
 * 
 * @author Zhang Junlong
 * 
 */
public interface AccountGroupDao extends GenericDao<AccountGroup, Integer> {
	Collection<AccountGroup> read() throws Exception;
}