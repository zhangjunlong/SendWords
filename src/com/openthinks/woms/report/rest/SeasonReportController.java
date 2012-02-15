package com.openthinks.woms.report.rest;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Validateable;
import com.openthinks.woms.report.service.SeasonReportService;

@Results({ @Result(name = "success", type = "redirectAction", params = {
		"actionName", "seasonReport" }) })
public class SeasonReportController implements ModelDriven<Object>,
		Validateable {

	private SeasonReportService seasonReportService;

	private String id;

	private Object model;

	public void setSeasonReportService(SeasonReportService seasonReportService) {
		this.seasonReportService = seasonReportService;
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
				model = seasonReportService.analyzeSeason("%", "%");
			else
				model = seasonReportService.analyzeSeason(id, "%");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "seasonReport";

	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub

	}
}
