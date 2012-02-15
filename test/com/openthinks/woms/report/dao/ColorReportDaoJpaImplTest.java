package com.openthinks.woms.report.dao;

import static org.junit.Assert.fail;

import java.util.Collection;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.openthinks.SpringTestSupport;
import com.openthinks.woms.report.ColorReportItem;

public class ColorReportDaoJpaImplTest extends SpringTestSupport {

	@Autowired
	private ColorReportDao colorReportDao;

	@Test
	public void testCountColor() {
		try {
			Collection<ColorReportItem> result = colorReportDao.countColor("%",
					"%");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
