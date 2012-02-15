package com.openthinks.woms.product.service;

import java.util.Collection;

import com.openthinks.woms.product.Series;

public interface SeriesService {
	void create(Series series) throws Exception;

	Series find(int id) throws Exception;

	Collection<Series> find() throws Exception;

	void update(Series series) throws Exception;

	void delete(int id) throws Exception;
}
