package com.openthinks.woms.profile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Class of a person
 * 
 * @author Zhang Junlong
 * 
 */
@Entity
public class Class implements Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(length = 100)
	private String name;

	@Column(length = 20)
	private String code;

	@ManyToOne
	private Class parentCategory;

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

	public Class getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Class parentCategory) {
		this.parentCategory = parentCategory;
	}

}
