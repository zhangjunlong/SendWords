package com.openthinks.woms.product.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.openthinks.woms.product.Color;
import com.openthinks.woms.product.dao.ColorDao;

public class ColorServiceImpl implements ColorService {

	@Autowired
	private ColorDao colorDao;

	@Override
	public void create(Color color) throws Exception {
		colorDao.create(color);
	}

	@Override
	public Color find(int id) throws Exception {
		return colorDao.read(id);
	}

	@Override
	public Collection<Color> find() throws Exception {
		return colorDao.read();
	}

	@Override
	public void update(Color color) throws Exception {
		colorDao.update(color);
	}

	@Override
	public void delete(int id) throws Exception {
		Color persistentColor = colorDao.read(id);
		colorDao.delete(persistentColor);
	}

}
