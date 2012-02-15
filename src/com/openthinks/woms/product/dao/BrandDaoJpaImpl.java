package com.openthinks.woms.product.dao;

import java.util.List;

import com.openthinks.dao.GenericJpaDaoBean;
import com.openthinks.woms.product.Brand;

public class BrandDaoJpaImpl extends GenericJpaDaoBean<Brand, Integer>
		implements BrandDao {

	public BrandDaoJpaImpl() {
		super(Brand.class);
	}

	@Override
	public List<Brand> read() throws Exception {
		String ql = "select b from Brand b";
		return this.readSpecifiedSection(ql, 0, 1).getResultList();
	}
}
