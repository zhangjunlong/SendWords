package com.openthinks.woms.profile;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.openthinks.woms.account.Account;

/**
 * Individual person
 * 
 * @author Zhang Junlong
 * 
 */
@Entity
public class Person extends Account implements Profile {

	@Column(length = 10, unique = true)
	private String gender;

	@Column(length = 30)
	private String name;

	@Column(length = 128)
	private String picture;

	@Column(length = 10)
	private String birthday;

	@ManyToOne
	private Class attendedClasses;

	@Column(length = 128)
	private String hometown;

	@Column(length = 100)
	private String remark;

	public Person() {
		super();
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Class getAttendedClasses() {
		return attendedClasses;
	}

	public void setAttendedClasses(Class attendedClasses) {
		this.attendedClasses = attendedClasses;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

}
