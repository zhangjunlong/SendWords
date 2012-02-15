package com.openthinks.woms.product.dao;

import java.util.Collection;

import com.openthinks.dao.GenericJpaDaoBean;
import com.openthinks.woms.product.Season;

public class SeasonDaoJpaImpl extends GenericJpaDaoBean<Season, Integer>
		implements SeasonDao {

	public SeasonDaoJpaImpl() {
		super(Season.class);
	}

	@Override
	public Collection<Season> read() throws Exception {
		String ql = "select s from Season s";
		return this.readSpecifiedSection(ql, 0, 1).getResultList();
	}

}
