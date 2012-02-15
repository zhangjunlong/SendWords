package com.openthinks.woms.report.rest;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Validateable;
import com.openthinks.woms.report.CategoryReport;
import com.openthinks.woms.report.service.CategoryReportService;

@Results({ @Result(name = "success", type = "redirectAction", params = {
		"actionName", "categoryReport" }) })
public class CategoryReportController implements ModelDriven<Object>,
		Validateable {

	private CategoryReportService categoryReportService;

	private String id;

	private Object model;

	public void setCategoryReportService(
			CategoryReportService categoryReportService) {
		this.categoryReportService = categoryReportService;
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
				model = categoryReportService.analyzeCategory(id, "%");
			else
				model = categoryReportService.analyzeCategory("%", "%");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "categoryReport";
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub

	}
}
