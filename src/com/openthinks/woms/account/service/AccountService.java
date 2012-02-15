package com.openthinks.woms.account.service;

import java.util.Collection;
import java.util.List;

import com.openthinks.woms.account.Account;

/**
 * Account Service Interface
 * 
 * @author Zhang Junlong
 * 
 */
public interface AccountService {
	/**
	 * Authorize a account
	 * 
	 * @return
	 */
	Account authorize(String id, String password) throws Exception;

	/**
	 * Find out an account by account's id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Account find(int id) throws Exception;

	/**
	 * Find out all accounts
	 * 
	 * @return
	 */
	Collection<Account> find() throws Exception;

	void create(Account account) throws Exception;

	void update(Account account) throws Exception;

	void delete(int id) throws Exception;

	List<Object> accountTask(int accountId) throws Exception;

	Account find(String userId) throws Exception;

}
