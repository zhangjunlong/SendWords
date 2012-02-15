package com.openthinks.woms.product.service;

import java.util.Collection;
import java.util.List;

import com.openthinks.dao.SectionResult;
import com.openthinks.woms.product.Product;

/**
 * Service interface of products
 * 
 * @author Zhang Junlong
 * 
 */
public interface ProductService {

	/**
	 * Create a new product.
	 * 
	 * @param product
	 */
	void create(Product product) throws Exception;

	/**
	 * Create a list of products
	 * 
	 * @param products
	 * @throws Exception
	 */
	void create(Collection<Product> products) throws Exception;

	/**
	 * Find out all products
	 * 
	 * @return
	 */
	Collection<Product> find() throws Exception;

	SectionResult<Product> find(int size,int section) throws Exception;
	
	SectionResult<Object> find(String accountId, String keywords,String productSeason,String productStyle, int orderType, int size,int section) throws Exception;

	/**
	 * Find a product by id
	 * 
	 * @param id
	 * @return
	 */
	Product find(long id) throws Exception;

	void update(Product product) throws Exception;

	void delete(long id) throws Exception;
	
	List<Object> getProductSeason() throws Exception;
}
