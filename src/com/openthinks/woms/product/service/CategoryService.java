package com.openthinks.woms.product.service;

import java.util.Collection;

import com.openthinks.woms.product.Category;

public interface CategoryService {
	void create(Category category) throws Exception;

	Category find(int id) throws Exception;

	Collection<Category> find() throws Exception;

	void update(Category category) throws Exception;

	void delete(int id) throws Exception;
}
