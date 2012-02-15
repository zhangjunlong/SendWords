package com.openthinks.woms.report.dao;

import static org.junit.Assert.fail;

import java.util.Collection;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.openthinks.SpringTestSupport;
import com.openthinks.woms.report.SeriesReportItem;

public class SeriesReportDaoJpaImplTest extends SpringTestSupport {

	@Autowired
	private SeriesReportDao seriesReportDao;

	@Test
	public void testCountSeries() {
		try {
			Collection<SeriesReportItem> result = seriesReportDao.countSeries("%",
					"%");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
