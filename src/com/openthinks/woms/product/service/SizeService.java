package com.openthinks.woms.product.service;

import java.util.Collection;

import com.openthinks.woms.product.Size;

public interface SizeService {

	void create(Size size) throws Exception;

	Size find(int id) throws Exception;

	Collection<Size> find() throws Exception;

	void update(Size size) throws Exception;

	void delete(int id) throws Exception;

}
