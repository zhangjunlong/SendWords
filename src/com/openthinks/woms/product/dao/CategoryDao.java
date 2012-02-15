package com.openthinks.woms.product.dao;

import java.util.Collection;

import com.openthinks.dao.GenericDao;
import com.openthinks.woms.product.Category;

public interface CategoryDao extends GenericDao<Category, Integer> {
	/**
	 * Read all records
	 * 
	 * @return
	 */
	Collection<Category> read() throws Exception;
}
