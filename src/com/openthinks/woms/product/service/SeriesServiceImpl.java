package com.openthinks.woms.product.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.openthinks.woms.product.Series;
import com.openthinks.woms.product.dao.SeriesDao;

public class SeriesServiceImpl implements SeriesService {

	@Autowired
	private SeriesDao seriesDao;

	@Override
	public void create(Series series) throws Exception {
		seriesDao.create(series);
	}

	@Override
	public Series find(int id) throws Exception {
		return seriesDao.read(id);
	}

	@Override
	public Collection<Series> find() throws Exception {
		return seriesDao.read();
	}

	@Override
	public void update(Series series) throws Exception {
		seriesDao.update(series);
	}

	@Override
	public void delete(int id) throws Exception {
		Series series = seriesDao.read(id);
		seriesDao.delete(series);
	}

}
