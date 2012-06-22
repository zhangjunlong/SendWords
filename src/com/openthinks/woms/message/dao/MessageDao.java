package com.openthinks.woms.message.dao;

import java.util.Collection;

import com.openthinks.dao.GenericDao;
import com.openthinks.woms.message.Message;

public interface MessageDao extends GenericDao<Message, Long> {

	/**
	 * Read out messages of specified sender
	 * 
	 * @param uid
	 * @throws Exception
	 */
	Collection<Message> find(long uid) throws Exception;

	/**
	 * Read out all messages
	 * 
	 * @return
	 * @throws Exception 
	 */
	Collection<Message> read() throws Exception;

}
