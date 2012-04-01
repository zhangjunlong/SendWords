package com.openthinks.woms.profile.dao.impl;

import java.util.Collection;

import com.openthinks.dao.GenericJpaDaoBean;
import com.openthinks.woms.profile.Class;
import com.openthinks.woms.profile.dao.ClassDao;

public class ClassDaoJpaImpl extends GenericJpaDaoBean<Class, Integer>
		implements ClassDao {

	public ClassDaoJpaImpl() {
		super(Class.class);
	}

	@Override
	public Collection<Class> read() throws Exception {
		String ql = "select c from Class c";
		return this.readSpecifiedSection(ql, 0, 1).getResultList();
	}

}
