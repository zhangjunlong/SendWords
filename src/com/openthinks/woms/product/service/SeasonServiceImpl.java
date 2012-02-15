package com.openthinks.woms.product.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.openthinks.woms.product.Season;
import com.openthinks.woms.product.dao.SeasonDao;

public class SeasonServiceImpl implements SeasonService {

	@Autowired
	private SeasonDao seasonDao;

	@Override
	public void create(Season season) throws Exception {
		seasonDao.create(season);
	}

	@Override
	public Season find(int id) throws Exception {
		return seasonDao.read(id);
	}

	@Override
	public Collection<Season> find() throws Exception {
		return seasonDao.read();
	}

	@Override
	public void update(Season season) throws Exception {
		seasonDao.update(season);
	}

	@Override
	public void delete(int id) throws Exception {
	    Season season = seasonDao.read(id);
		seasonDao.delete(season);
	}

}
