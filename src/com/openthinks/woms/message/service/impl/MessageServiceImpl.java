package com.openthinks.woms.message.service.impl;

import java.util.Collection;

import com.openthinks.woms.message.Message;
import com.openthinks.woms.message.dao.MessageDao;
import com.openthinks.woms.message.service.MessageService;

public class MessageServiceImpl implements MessageService {

	MessageDao messageDao;

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	@Override
	public void create(Message newMsg) throws Exception {
		messageDao.create(newMsg);
	}

	@Override
	public Collection<Message> retrieveMsgs(String uid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long msgId) throws Exception {
		Message msg = messageDao.read(msgId);
		messageDao.delete(msg);
	}

}
