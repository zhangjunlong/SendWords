package com.openthinks.woms.product.dao;

import java.util.Collection;

import com.openthinks.dao.GenericDao;
import com.openthinks.woms.product.Color;

public interface ColorDao extends GenericDao<Color, Integer> {
	Collection<Color> read() throws Exception;
}
