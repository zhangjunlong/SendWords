package com.openthinks.woms.profile.service.impl;

import java.util.Collection;
import java.util.List;

import com.openthinks.dao.SectionResult;
import com.openthinks.woms.profile.Person;
import com.openthinks.woms.profile.dao.PersonDao;
import com.openthinks.woms.profile.service.PersonService;

public class PersonServiceImpl implements PersonService {

	private PersonDao personDao;

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	@Override
	public List<Person> find() throws Exception {
		return personDao.read();
	}

	@Override
	public SectionResult<Person> find(int size, int section) throws Exception {
		return personDao.read(size, section);
	}

	@Override
	public SectionResult<Object> find(String accountId, String keywords,
			String productSeason, String productStyle, int orderType, int size,
			int section) throws Exception {
		return personDao.read(accountId, keywords, productSeason, productStyle,
				orderType, size, section);
	}

	@Override
	public Person find(long id) throws Exception {
		return personDao.read(id);
	}

	public void create(Person person) throws Exception {
		personDao.create(person);
	}

	public void create(Collection<Person> people) throws Exception {
		try {
			for (Person person : people) {
				personDao.create(person);
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void update(Person person) throws Exception {
		Person pPerson = personDao.read(person.getId());

		if (null != person.getBirthday())
			pPerson.setBirthday(person.getBirthday());

		if (null != person.getGender())
			pPerson.setGender(person.getGender());

		if (null != person.getHometown())
			pPerson.setHometown(person.getHometown());

		if (null != person.getPicture())
			pPerson.setPicture(person.getPicture());

		if (null != person.getRemark())
			pPerson.setRemark(person.getRemark());

		personDao.update(pPerson);
	}

	@Override
	public void delete(long id) throws Exception {
		Person persistentPerson = personDao.read(id);
		personDao.delete(persistentPerson);
	}

}
