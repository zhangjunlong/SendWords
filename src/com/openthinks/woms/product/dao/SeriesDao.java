package com.openthinks.woms.product.dao;

import java.util.Collection;

import com.openthinks.dao.GenericDao;
import com.openthinks.woms.product.Series;

public interface SeriesDao extends GenericDao<Series, Integer> {
	Collection<Series> read() throws Exception;
}
