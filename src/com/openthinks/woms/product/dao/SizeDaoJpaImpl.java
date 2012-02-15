package com.openthinks.woms.product.dao;

import java.util.Collection;

import com.openthinks.dao.GenericJpaDaoBean;
import com.openthinks.woms.product.Size;

public class SizeDaoJpaImpl extends GenericJpaDaoBean<Size, Integer>
		implements SizeDao {

	public SizeDaoJpaImpl() {
		super(Size.class);
	}

	@Override
	public Collection<Size> read() throws Exception {
		String ql = "select ss from Size ss";

		return readSpecifiedSection(ql, 0, 1).getResultList();
	}

}
