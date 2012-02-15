package com.openthinks.woms.report.rest;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Validateable;
import com.openthinks.woms.report.service.ModelReportService;

@Results({ @Result(name = "success", type = "redirectAction", params = {
		"actionName", "modelReportByAccount" }) })
public class ModelReportController implements ModelDriven<Object>, Validateable {

	private Object model;

	private String id;

	private ModelReportService modelReportService;

	public void setId(String id) {
		this.id = id;
	}

	public void setModelReportService(ModelReportService modelReportService) {
		this.modelReportService = modelReportService;
	}

	@Override
	public Object getModel() {
		return model;
	}

	public String show() {
		try {
			if ("-1".equals(id))
				model = modelReportService.analyzeModelByAccount("%");
			else
				model = modelReportService.analyzeModelByAccount(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "modelReportByAccount";
	}

	@Override
	public void validate() {

	}

}
