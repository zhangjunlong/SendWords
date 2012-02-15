package com.openthinks.woms.product.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.openthinks.SpringTestSupport;
import com.openthinks.woms.product.Product;

@Transactional
public class ProductDaoTest extends SpringTestSupport {
	@Autowired
	private ProductDao productDao;

	@Test
	public void testCrud() throws Exception {

		Product product = new Product();
		product.setName("name");
		product.setOrderingPrice(0);

		productDao.create(product);
		Product persistedProduct = productDao.read(product.getId());
		assertEquals(product.getName(), persistedProduct.getName());

		product.setOrderingPrice(100.0);
		productDao.update(product);
		persistedProduct = productDao.read(product.getId());
		assertEquals(product.getOrderingPrice(),
				persistedProduct.getOrderingPrice(), 0.0);

		productDao.delete(product);
		persistedProduct = productDao.read(product.getId());
		assertNull(persistedProduct);

	}
}
