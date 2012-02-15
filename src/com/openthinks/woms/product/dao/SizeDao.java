package com.openthinks.woms.product.dao;

import java.util.Collection;

import com.openthinks.dao.GenericDao;
import com.openthinks.woms.product.Size;

public interface SizeDao extends GenericDao<Size, Integer> {
	Collection<Size> read() throws Exception;
}
