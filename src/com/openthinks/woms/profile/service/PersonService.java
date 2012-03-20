package com.openthinks.woms.profile.service;

import java.util.Collection;

import com.openthinks.dao.SectionResult;
import com.openthinks.woms.profile.Person;

/**
 * Service interface of persons
 * 
 * @author Zhang Junlong
 * 
 */
public interface PersonService {

	/**
	 * Create a new person.
	 * 
	 * @param person
	 */
	void create(Person person) throws Exception;

	/**
	 * Create a list of persons
	 * 
	 * @param persons
	 * @throws Exception
	 */
	void create(Collection<Person> persons) throws Exception;

	/**
	 * Find out all persons
	 * 
	 * @return
	 */
	Collection<Person> find() throws Exception;

	SectionResult<Person> find(int size, int section) throws Exception;

	SectionResult<Object> find(String accountId, String keywords,
			String personSeason, String personStyle, int orderType, int size,
			int section) throws Exception;

	/**
	 * Find a person by id
	 * 
	 * @param id
	 * @return
	 */
	Person find(long id) throws Exception;

	void update(Person person) throws Exception;

	void delete(long id) throws Exception;

}
