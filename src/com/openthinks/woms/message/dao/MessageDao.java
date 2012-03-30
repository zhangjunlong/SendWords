package com.openthinks.woms.message.dao;

import java.util.Collection;

import com.openthinks.dao.GenericDao;
import com.openthinks.woms.message.Message;

public interface MessageDao extends GenericDao<Message, Long> {

	/**
	 * Get messages of specified userId
	 * 
	 * @param uid
	 * @throws Exception 
	 */
	Collection<Message> find(long uid) throws Exception;

}
