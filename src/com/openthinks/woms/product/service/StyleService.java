package com.openthinks.woms.product.service;

import java.util.Collection;

import com.openthinks.woms.product.Style;

public interface StyleService {
	void create(Style style) throws Exception;

	Style find(int id) throws Exception;

	Collection<Style> find() throws Exception;

	void update(Style style) throws Exception;

	void delete(int id) throws Exception;
}
