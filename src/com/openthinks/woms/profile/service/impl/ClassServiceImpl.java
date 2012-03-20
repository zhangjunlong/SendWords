package com.openthinks.woms.profile.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.openthinks.woms.profile.Class;
import com.openthinks.woms.profile.dao.ClassDao;
import com.openthinks.woms.profile.service.ClassService;

public class ClassServiceImpl implements ClassService {

	@Autowired
	private ClassDao categoryDao;

	@Override
	public void create(Class category) throws Exception {
		categoryDao.create(category);
	}

	@Override
	public Class find(int id) throws Exception {
		return categoryDao.read(id);
	}

	@Override
	public Collection<Class> find() throws Exception {
		return categoryDao.read();
	}

	@Override
	public void update(Class category) throws Exception {
		categoryDao.update(category);
	}

	@Override
	public void delete(int id) throws Exception {
		Class category = categoryDao.read(id);
		categoryDao.delete(category);
	}

}
