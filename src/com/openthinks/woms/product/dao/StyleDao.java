package com.openthinks.woms.product.dao;

import java.util.Collection;

import com.openthinks.dao.GenericDao;
import com.openthinks.woms.product.Style;

public interface StyleDao extends GenericDao<Style, Integer> {
	Collection<Style> read() throws Exception;
}
