package com.openthinks.woms.profile;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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

	private String picture;

	@Column(length = 100)
	private String name;

	@OneToMany
	private List<Person> classmates;

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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public List<Person> getClassmates() {
		return classmates;
	}

	public void setClassmates(List<Person> classmates) {
		this.classmates = classmates;
	}

}
