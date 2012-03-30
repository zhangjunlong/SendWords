package com.openthinks.woms.message;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.openthinks.woms.account.Account;

/**
 * Account Model
 * 
 * @author Zhang Wenlong
 * 
 */
@Entity
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String content;

	@ManyToOne
	private Account sender;

	@ManyToOne
	private Account receiver;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private int currentNoticeVersion;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Account getSender() {
		return sender;
	}

	public void setSender(Account sender) {
		this.sender = sender;
	}

	public Account getReceiver() {
		return receiver;
	}

	public void setReceiver(Account receiver) {
		this.receiver = receiver;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCurrentNoticeVersion() {
		return currentNoticeVersion;
	}

	public void setCurrentNoticeVersion(int currentNoticeVersion) {
		this.currentNoticeVersion = currentNoticeVersion;
	}

}
