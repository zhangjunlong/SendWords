package com.openthinks.woms.message.dao.impl;

import java.util.Collection;

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

	@Override
	public Collection<Message> find(long uid) throws Exception {
		String ql = "SELECT m FROM Message m WHERE m.receiver.id = ?0";

		return this.query(ql, uid);
	}

	@Override
	public Collection<Message> read() throws Exception {
		String ql = "SELECT m FROM Message m";
		return this.readSpecifiedSection(ql, 0, 0).getResultList();
	}
}
