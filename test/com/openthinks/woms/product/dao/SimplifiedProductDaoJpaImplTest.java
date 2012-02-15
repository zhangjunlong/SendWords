package com.openthinks.woms.product.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.openthinks.SpringTestSupport;

public class SimplifiedProductDaoJpaImplTest extends SpringTestSupport {
	@Autowired
	private SimplifiedProductDao simplifiedProductDao;

	@Test
	public void testFind() throws Exception {
		simplifiedProductDao.read("%", 10, 1);
	}
}
