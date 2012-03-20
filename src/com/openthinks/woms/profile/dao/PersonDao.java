package com.openthinks.woms.profile.dao;

import java.util.List;

import com.openthinks.dao.GenericDao;
import com.openthinks.dao.SectionResult;
import com.openthinks.woms.profile.Person;

public interface PersonDao extends GenericDao<Person, Long> {
	/**
	 * Read out all people
	 * 
	 * @param section
	 * @return
	 */
	List<Person> read() throws Exception;

	SectionResult<Person> read(int size, int section) throws Exception;

	SectionResult<Object> read(String accountId, String keywords,
			String productSeason, String productStyle, int orderType, int size,
			int section) throws Exception;
}