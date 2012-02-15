package com.openthinks.woms.product.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.openthinks.woms.product.Style;
import com.openthinks.woms.product.dao.StyleDao;

public class StyleServiceImpl implements StyleService {

	@Autowired
	private StyleDao styleDao;

	@Override
	public void create(Style style) throws Exception {
		styleDao.create(style);
	}

	@Override
	public Style find(int id) throws Exception {
		return styleDao.read(id);
	}

	@Override
	public Collection<Style> find() throws Exception {
		return styleDao.read();
	}

	@Override
	public void update(Style style) throws Exception {
		styleDao.update(style);
	}

	@Override
	public void delete(int id) throws Exception {
		Style style = styleDao.read(id);
		styleDao.delete(style);
	}

}
