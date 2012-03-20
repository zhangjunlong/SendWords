package com.openthinks.woms.profile.rest;

/**
 * A simply model for query
 * 
 * @author Zhang Junlong
 * 
 */
public class SimplyQuery {
	// Query keywords
	private String keywords = "%";
	// Indicated page no. of result
	private int page;

	private int pageSize;

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}