package com.openthinks.woms.report.rest;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Validateable;
import com.openthinks.woms.report.StyleReport;
import com.openthinks.woms.report.service.StyleReportService;

@Results({ @Result(name = "success", type = "redirectAction", params = {
		"actionName", "styleReport" }) })
public class StyleReportController implements ModelDriven<Object>, Validateable {

	private StyleReportService styleReportService;

	private String id;

	private Object model;

	public void setStyleReportService(StyleReportService styleReportService) {
		this.styleReportService = styleReportService;
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
				model = styleReportService.analyzeStyle(id, "%");
			else
				model = styleReportService.analyzeStyle("%", "%");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "styleReport";
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub

	}
}
