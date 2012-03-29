package com.openthinks.woms.message.service;

import java.util.Collection;

import com.openthinks.woms.message.Message;

public interface MessageService {

	void create(Message msg) throws Exception;

	/**
	 * Retrieve an user's messages
	 * 
	 * @param uid
	 * @return
	 */
	Collection<Message> retrieveMsgs(String uid) throws Exception;

	void delete(long msgId) throws Exception;

}
