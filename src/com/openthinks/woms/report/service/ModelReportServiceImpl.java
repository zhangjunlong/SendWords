package com.openthinks.woms.report.service;

import java.util.Collection;

import com.openthinks.woms.report.ModelReportByAccountItem;
import com.openthinks.woms.report.dao.ModelReportDao;

public class ModelReportServiceImpl implements ModelReportService {

	private ModelReportDao modelReportDao;

	public void setModelReportDao(ModelReportDao modelReportDao) {
		this.modelReportDao = modelReportDao;
	}

	@Override
	public Collection<ModelReportByAccountItem> analyzeModelByAccount(
			String accountId) throws Exception {
		return modelReportDao.countModeByAccount(accountId);
	}
}
