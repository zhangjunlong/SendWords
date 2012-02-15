package com.openthinks.woms.product.dao;

import java.util.Collection;

import com.openthinks.dao.GenericJpaDaoBean;
import com.openthinks.woms.product.Color;

public class ColorDaoJpaImpl extends GenericJpaDaoBean<Color, Integer>
		implements ColorDao {

	public ColorDaoJpaImpl() {
		super(Color.class);
	}

	@Override
	public Collection<Color> read() throws Exception {
		String ql = "select c from Color c";
		return readSpecifiedSection(ql, 0, 1).getResultList();
	}

}
