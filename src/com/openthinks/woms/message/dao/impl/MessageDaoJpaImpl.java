package com.openthinks.woms.message.dao.impl;

import com.openthinks.dao.GenericJpaDaoBean;
import com.openthinks.woms.message.Message;
import com.openthinks.woms.message.dao.MessageDao;

/**
 * A implementation of JPA data access for account
 * 
 * @author Zhang Junlong
 * 
 */
public class MessageDaoJpaImpl extends GenericJpaDaoBean<Message, Long>
		implements MessageDao {

	public MessageDaoJpaImpl() {
		super(Message.class);
	}
}
