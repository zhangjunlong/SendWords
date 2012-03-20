package com.openthinks.woms.profile.dao;

import java.util.Collection;

import com.openthinks.dao.GenericDao;
import com.openthinks.woms.profile.Class;

public interface ClassDao extends GenericDao<Class, Integer> {
	/**
	 * Read all records
	 * 
	 * @return
	 */
	Collection<Class> read() throws Exception;
}
