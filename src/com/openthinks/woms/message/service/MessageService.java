package com.openthinks.woms.message.service;

import java.util.Collection;

import com.openthinks.woms.message.Message;

public interface MessageService {

	Message create(String content, long senderId, long receiverId)
			throws Exception;

	/**
	 * Retrieve an user's messages
	 * 
	 * @param uid
	 * @return
	 */
	Collection<Message> retrieveMsgs(long uid) throws Exception;

	void delete(long msgId) throws Exception;

}
