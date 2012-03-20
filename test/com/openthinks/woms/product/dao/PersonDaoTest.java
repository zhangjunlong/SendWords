package com.openthinks.woms.product.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.openthinks.SpringTestSupport;
import com.openthinks.woms.profile.Person;
import com.openthinks.woms.profile.dao.PersonDao;

@Transactional
public class PersonDaoTest extends SpringTestSupport {
	@Autowired
	private PersonDao productDao;

	@Test
	public void testCrud() throws Exception {

		Person person = new Person();
		person.setName("name");

		productDao.create(person);
		Person persistedProduct = productDao.read(person.getId());
		assertEquals(person.getName(), persistedProduct.getName());

		person.setGender("male");
		productDao.update(person);
		persistedProduct = productDao.read(person.getId());
		assertEquals(person.getGender(), persistedProduct.getGender(), 0.0);

		productDao.delete(person);
		persistedProduct = productDao.read(person.getId());
		assertNull(persistedProduct);

	}
}
