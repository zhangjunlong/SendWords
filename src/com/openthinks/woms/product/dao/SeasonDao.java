package com.openthinks.woms.product.dao;

import java.util.Collection;

import com.openthinks.dao.GenericDao;
import com.openthinks.woms.product.Season;

public interface SeasonDao extends GenericDao<Season, Integer> {
	Collection<Season> read() throws Exception;
}
