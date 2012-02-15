package com.openthinks.woms.product.service;

import java.util.Collection;

import com.openthinks.woms.product.Color;

public interface ColorService {
	void create(Color color) throws Exception;

	Color find(int id) throws Exception;

	Collection<Color> find() throws Exception;

	void update(Color color) throws Exception;

	void delete(int id) throws Exception;
}
