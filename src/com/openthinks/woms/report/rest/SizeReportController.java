package com.openthinks.woms.report.rest;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Validateable;
import com.openthinks.woms.report.service.SizeReportService;

@Results({ @Result(name = "success", type = "redirectAction", params = {
		"actionName", "sizeReport" }) })
public class SizeReportController implements ModelDriven<Object>, Validateable {

	private Object model = new Candidate();

	private String id;

	private SizeReportService sizeReportService;

	public void setId(String id) {
		this.id = id;
	}

	public void setSizeReportService(SizeReportService sizeReportService) {
		this.sizeReportService = sizeReportService;
	}

	@Override
	public Object getModel() {
		return model;
	}

	public String show() {
		try {
			Candidate candidate = (Candidate) model;

			if ("-1".equals(id))
				model = sizeReportService.analyzeSizeByCandidate("%",
						candidate.getName());
			else
				model = sizeReportService.analyzeSizeByCandidate(id,
						candidate.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "modelReportByAccount";
	}

	@Override
	public void validate() {

	}

}

class Candidate {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}