package com.openthinks.woms.report.dao;

import static org.junit.Assert.fail;

import java.util.Collection;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.openthinks.SpringTestSupport;
import com.openthinks.woms.report.SeasonReportItem;

public class SeasonReportDaoJpaImplTest extends SpringTestSupport {

	@Autowired
	private SeasonReportDao seasonReportDao;

	@Test
	public void testCountSeason() {
		try {
			Collection<SeasonReportItem> result = seasonReportDao.countSeason(
					"%", "%");
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
