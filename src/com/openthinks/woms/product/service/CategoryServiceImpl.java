package com.openthinks.woms.product.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.openthinks.woms.product.Category;
import com.openthinks.woms.product.dao.CategoryDao;

public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public void create(Category category) throws Exception {
		categoryDao.create(category);
	}

	@Override
	public Category find(int id) throws Exception {
		return categoryDao.read(id);
	}

	@Override
	public Collection<Category> find() throws Exception {
		return categoryDao.read();
	}

	@Override
	public void update(Category category) throws Exception {
		categoryDao.update(category);
	}

	@Override
	public void delete(int id) throws Exception {
		Category category = categoryDao.read(id);
		categoryDao.delete(category);
	}

}
