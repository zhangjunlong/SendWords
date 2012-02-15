package com.openthinks.woms.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Color for different kinds of products
 * 
 * @author Zhang Junlong
 * 
 */
@Entity
public class Color {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(length = 20)
	private String code;

	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
