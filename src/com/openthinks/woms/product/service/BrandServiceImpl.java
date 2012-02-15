package com.openthinks.woms.product.service;

import java.util.Collection;

import com.openthinks.woms.product.Brand;
import com.openthinks.woms.product.dao.BrandDao;

public class BrandServiceImpl implements BrandService {

	private BrandDao brandDao;

	public void setBrandDao(BrandDao brandDao) {
		this.brandDao = brandDao;
	}

	public void create(Brand brand) throws Exception {
		brandDao.create(brand);
	}

	@Override
	public Brand find(int id) throws Exception {
		return brandDao.read(id);
	}

	@Override
	public void delete(int id) throws Exception {
		Brand persistentObject = brandDao.read(id);
		brandDao.delete(persistentObject);
	}

	@Override
	public void update(Brand brand) throws Exception {
		brandDao.update(brand);
	}

	@Override
	public Collection<Brand> find() throws Exception {
		return brandDao.read();
	}

}
