package com.openthinks.woms.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Series of product
 * 
 * @author Zhang Junlong
 * 
 */
@Entity
public class Series {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(length = 50)
	private String name;

	@Column(length = 20)
	private String code;

	@ManyToOne
	private Series parentSeries;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Series getParentSeries() {
		return parentSeries;
	}

	public void setParentSeries(Series parentSeries) {
		this.parentSeries = parentSeries;
	}

}
