package com.openthinks.woms.product.service;

import java.util.Collection;

import com.openthinks.woms.product.Season;

public interface SeasonService {
	void create(Season season) throws Exception;

	Season find(int id) throws Exception;

	Collection<Season> find() throws Exception;

	void update(Season season) throws Exception;

	void delete(int id) throws Exception;
}
