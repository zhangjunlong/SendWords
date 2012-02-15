package com.openthinks.woms.report.rest;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Validateable;
import com.openthinks.woms.report.SeriesReport;
import com.openthinks.woms.report.service.SeriesReportService;

@Results({ @Result(name = "success", type = "redirectAction", params = {
		"actionName", "seriesReport" }) })
public class SeriesReportController implements ModelDriven<Object>,
		Validateable {

	private SeriesReportService seriesReportService;

	private String id;

	private Object model;

	public void setSeriesReportService(SeriesReportService seriesReportService) {
		this.seriesReportService = seriesReportService;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public Object getModel() {
		return model;
	}

	public String show() {
		try {
			if (null == id)
				model = seriesReportService.analyzeSeries("%", "%");
			else
				model = seriesReportService.analyzeSeries(id, "%");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "seriesReport";

	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub

	}
}
