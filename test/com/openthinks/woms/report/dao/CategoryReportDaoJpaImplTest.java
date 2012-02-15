package com.openthinks.woms.report.dao;

import static org.junit.Assert.fail;

import java.util.Collection;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.openthinks.SpringTestSupport;
import com.openthinks.woms.report.CategoryReportItem;

public class CategoryReportDaoJpaImplTest extends SpringTestSupport {

	@Autowired
	private CategoryReportDao categoryReportDao;

	@Test
	public void testCountCategory() {
		try {
			Collection<CategoryReportItem> result = categoryReportDao.countCategory("%",
					"%");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
