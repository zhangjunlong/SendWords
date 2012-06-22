package com.openthinks.woms.message.service;

import java.util.Collection;

import com.openthinks.woms.message.Message;

public interface MessageService {

	Message create(String content, long senderId, long receiverId)
			throws Exception;

	/**
	 * Retrieve messages by sender's UID
	 * 
	 * @param uid
	 * @return
	 */
	Collection<Message> retrieveMsgs(long uid) throws Exception;

	void delete(long msgId) throws Exception;

	Collection<Message> retrieveAllMsgs() throws Exception;

}
