package com.openthinks.woms.product.dao;

import java.util.Collection;

import com.openthinks.dao.GenericJpaDaoBean;
import com.openthinks.woms.product.Style;

public class StyleDaoJpaImpl extends GenericJpaDaoBean<Style, Integer>
		implements StyleDao {

	public StyleDaoJpaImpl() {
		super(Style.class);
	}

	@Override
	public Collection<Style> read() throws Exception {
		String ql = "select s from Style s";
		return this.readSpecifiedSection(ql, 0, 1).getResultList();
	}

}
