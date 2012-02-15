package com.openthinks.woms.product.dao;

import java.util.List;

import com.openthinks.dao.GenericDao;
import com.openthinks.woms.product.Brand;

public interface BrandDao extends GenericDao<Brand, Integer> {
	List<Brand> read() throws Exception;
}