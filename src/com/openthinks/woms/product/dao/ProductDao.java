package com.openthinks.woms.product.dao;

import java.util.List;

import com.openthinks.dao.GenericDao;
import com.openthinks.dao.SectionResult;
import com.openthinks.woms.product.Product;

public interface ProductDao extends GenericDao<Product, Long> {
	/**
	 * 
	 * @param section
	 * @return
	 */
	List<Product> read() throws Exception;

	SectionResult<Product> read(int size, int section) throws Exception;

	SectionResult<Object> read(String accountId, String keywords,
			String productSeason, String productStyle, int orderType, int size,
			int section) throws Exception;
}