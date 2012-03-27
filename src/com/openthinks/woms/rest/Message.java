package com.openthinks.woms.rest;

public class Message {

	public static final String SUCCESS = "success";
	public static final String FAILURE = "failure";
	public static final String WARNING = "warning";

	private String status;
	private String description;
	// Extend message object to be return;
	private Object extend;

	public Message() {
		super();
	}

	public Message(String status) {
		super();
		this.status = status;
	}

	public Message(String status, String description) {
		super();
		this.status = status;
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Object getExtend() {
		return extend;
	}

	public void setExtend(Object extend) {
		this.extend = extend;
	}

}
