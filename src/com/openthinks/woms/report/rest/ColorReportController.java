package com.openthinks.woms.report.rest;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Validateable;
import com.openthinks.woms.report.ColorReport;
import com.openthinks.woms.report.service.ColorReportService;

@Results({ @Result(name = "success", type = "redirectAction", params = {
		"actionName", "colorReport" }) })
public class ColorReportController implements ModelDriven<Object>, Validateable {

	private ColorReportService colorReportService;

	private String id;

	private Object model;

	public void setColorReportService(ColorReportService colorReportService) {
		this.colorReportService = colorReportService;
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
			if (null != id)
				model = colorReportService.analyzeColor(id, "%");
			else
				model = colorReportService.analyzeColor("%", "%");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "colorReport";
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub

	}
}
