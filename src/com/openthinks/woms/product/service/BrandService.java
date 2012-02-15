package com.openthinks.woms.product.service;

import java.util.Collection;

import com.openthinks.woms.product.Brand;

public interface BrandService {

	public void create(Brand brand) throws Exception;

	public Brand find(int id) throws Exception;

	public void delete(int id) throws Exception;

	public void update(Brand brand) throws Exception;

	public Collection<Brand> find() throws Exception;
}
