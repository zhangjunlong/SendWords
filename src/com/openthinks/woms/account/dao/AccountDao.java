package com.openthinks.woms.account.dao;

import java.util.Collection;

import com.openthinks.dao.GenericDao;
import com.openthinks.woms.account.Account;

/**
 * Data access interface for account
 * 
 * @author Zhang Junlong
 * 
 */
public interface AccountDao extends GenericDao<Account, Integer> {

	/**
	 * Read user by User ID
	 * 
	 * @param userId
	 * @return
	 * @throws Exceptoin
	 */
	Account read(String userId) throws Exception;

	/**
	 * Read out all persisted Accounts
	 * 
	 * @return
	 * @throws Exception
	 */
	Collection<Account> read() throws Exception;

	double sumFinishOrderAmount(String id) throws Exception;

}