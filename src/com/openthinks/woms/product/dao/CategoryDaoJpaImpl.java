package com.openthinks.woms.product.dao;

import java.util.Collection;

import com.openthinks.dao.GenericJpaDaoBean;
import com.openthinks.woms.product.Category;

public class CategoryDaoJpaImpl extends GenericJpaDaoBean<Category, Integer>
		implements CategoryDao {

	public CategoryDaoJpaImpl() {
		super(Category.class);
	}

	@Override
	public Collection<Category> read() throws Exception {
		String ql = "select c from Category c";
		return this.readSpecifiedSection(ql, 0, 1).getResultList();
	}

}
