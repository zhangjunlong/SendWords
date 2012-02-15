package com.openthinks.woms.product.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.openthinks.woms.product.Size;
import com.openthinks.woms.product.dao.SizeDao;

public class SizeServiceImpl implements SizeService {

	@Autowired
	private SizeDao sizeDao;

	@Override
	public void create(Size size) throws Exception {
		sizeDao.create(size);
	}

	@Override
	public Size find(int id) throws Exception {
		return sizeDao.read(id);
	}

	@Override
	public Collection<Size> find() throws Exception {
		return sizeDao.read();
	}

	@Override
	public void update(Size size) throws Exception {
		sizeDao.update(size);
	}

	@Override
	public void delete(int id) throws Exception {
		Size persistentObject = sizeDao.read(id);
		sizeDao.delete(persistentObject);
	}

}
