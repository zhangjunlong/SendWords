package com.openthinks.woms.report.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Validateable;
import com.openthinks.woms.account.Account;
import com.openthinks.woms.account.OrderTask;
import com.openthinks.woms.account.service.AccountService;
import com.openthinks.woms.product.QueryParameters;
import com.openthinks.woms.report.SeriesReport;
import com.openthinks.woms.report.BrandBigtypeReport;
import com.openthinks.woms.report.BrandReport;
import com.openthinks.woms.report.DeliveryTimeReport;
import com.openthinks.woms.report.IntegrationReport;
import com.openthinks.woms.report.SeasonCategoryReport;
import com.openthinks.woms.report.SeasonReport;
import com.openthinks.woms.report.service.ReportService;
import com.openthinks.woms.util.MemoryClass;

/**
 * Controller of reporting
 * 
 * @author Zhang Junlong
 * 
 */
@Results({ @Result(name = "success", type = "redirectAction", params = {
		"actionName", "report" }) })
public class ReportController implements ModelDriven<Object>, Validateable,
		SessionAware {

	private Map<String, Object> session;

	private String id;

	private Object model;

	private SeriesReport seriesReport;

	private SeasonReport seasonReport;

	private DeliveryTimeReport deliveryTimeReport;

	private IntegrationReport integrationReport;

	private List<SeasonCategoryReport> seasonCategoryReports;

	private List<BrandBigtypeReport> brandBigtypeReports;

	private BrandReport brandReport;

	private QueryParameters qp;

	private List<String> brands;

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Autowired
	private ReportService reportService;

	@Autowired
	private AccountService accountService;

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public Object getModel() {
		return model;
	}

	public QueryParameters getQp() {
		return qp;
	}

	public void setQp(QueryParameters qp) {
		this.qp = qp;
	}

	public SeriesReport getBigTypeReport() {
		return seriesReport;
	}

	public SeasonReport getSeasonReport() {
		return seasonReport;
	}

	public DeliveryTimeReport getDeliveryTimeReport() {
		return deliveryTimeReport;
	}

	public IntegrationReport getIntegrationReport() {
		return integrationReport;
	}

	public List<SeasonCategoryReport> getSeasonCategoryReports() {
		return seasonCategoryReports;
	}

	public BrandReport getBrandReport() {
		return brandReport;
	}

	public List<BrandBigtypeReport> getBrandBigtypeReports() {
		return brandBigtypeReports;
	}

	public List<String> getBrands() {
		try {
			String accountId = (String) session.get("id");
			Account account;

			account = accountService.find(accountId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return brands;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub

	}

	public String showDeliveryTimeReport() {
		try {
			if ((Boolean) session.get("admin")) {
				deliveryTimeReport = reportService
						.analyzeDeliveryTime("%", "%");
			} else {
				if (null == qp) {
					qp = (QueryParameters) session.get("qp");
					if (null == qp) {
						qp = new QueryParameters();
						qp.setBrand(this.getBrands().get(0));
					}
				}

				deliveryTimeReport = reportService.analyzeDeliveryTime(id,
						qp.getBrand());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "deliveryTimeReport";
	}

	public String showIntegrationReport() {
		try {
			if (null == qp) {
				qp = (QueryParameters) session.get("qp");
				if (null == qp) {
					qp = new QueryParameters();
					qp.setBrand(this.getBrands().get(0));
				}
			}

			if ((Boolean) session.get("admin"))
				integrationReport = reportService.analyzeIntegration("%", "%");
			else
				integrationReport = reportService.analyzeIntegration(id,
						qp.getBrand());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "integrationReport";
	}

	public String showSeasonBigTypeReport() {
		try {
			if (null == qp) {
				qp = (QueryParameters) session.get("qp");
				if (null == qp) {
					qp = new QueryParameters();
					qp.setBrand(this.getBrands().get(0));
				}
			}

			seasonCategoryReports = reportService.analyzeSeasonBigType(id,
					qp.getBrand());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "seasonBigTypeReport";
	}

	public String showSeasonCategoryReport() {
		try {
			if (null == qp) {
				qp = (QueryParameters) session.get("qp");
				if (null == qp) {
					qp = new QueryParameters();
					qp.setBrand(this.getBrands().get(0));
				}
			}

			seasonCategoryReports = reportService.analyzeSeasonCategory(id,
					qp.getBrand());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "seasonCategoryReport";
	}

	public String showSeasonColorReport() {
		try {
			if (null == qp) {
				qp = (QueryParameters) session.get("qp");
				if (null == qp) {
					qp = new QueryParameters();
					qp.setBrand(this.getBrands().get(0));
				}
			}

			seasonCategoryReports = reportService.analyzeSeasonColor(id,
					qp.getBrand());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "seasonColorReport";
	}

	public String showBrandBigtypeReport() {
		try {
			if ((Boolean) session.get("admin"))
				brandBigtypeReports = reportService.analyzeBrandBigtype("%");
			else
				brandBigtypeReports = reportService.analyzeBrandBigtype(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "brandBigtypeReport";
	}

	public String showBrandReport() {
		try {
			if ((Boolean) session.get("admin"))
				brandReport = reportService.analyzeBrand("%");
			else
				brandReport = reportService.analyzeBrand(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "brandReport";

	}

}
