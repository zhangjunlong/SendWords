package com.openthinks.woms.message;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

	public int getCurrentNoticeVersion() {
		return currentNoticeVersion;
	}

	public void setCurrentNoticeVersion(int currentNoticeVersion) {
		this.currentNoticeVersion = currentNoticeVersion;
	}

}
