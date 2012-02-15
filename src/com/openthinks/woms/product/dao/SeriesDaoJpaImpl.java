package com.openthinks.woms.product.dao;

import java.util.Collection;

import com.openthinks.dao.GenericJpaDaoBean;
import com.openthinks.woms.product.Series;

public class SeriesDaoJpaImpl extends GenericJpaDaoBean<Series, Integer>
		implements SeriesDao {

	public SeriesDaoJpaImpl() {
		super(Series.class);
	}

	@Override
	public Collection<Series> read() throws Exception {
		String ql = "select s from Series s";
		return this.readSpecifiedSection(ql, 0, 1).getResultList();
	}

}
