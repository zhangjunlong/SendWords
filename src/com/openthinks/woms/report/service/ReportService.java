package com.openthinks.woms.report.service;

import java.util.List;

import com.openthinks.woms.report.SeriesReport;
import com.openthinks.woms.report.BrandBigtypeReport;
import com.openthinks.woms.report.BrandReport;
import com.openthinks.woms.report.DeliveryTimeReport;
import com.openthinks.woms.report.IntegrationReport;
import com.openthinks.woms.report.SeasonCategoryReport;
import com.openthinks.woms.report.SeasonReport;
import com.openthinks.woms.report.StructureReport;
import com.openthinks.woms.report.StyleReport;

/**
 * Service interface of generating order reports
 * 
 * @author Zhang Junlong
 * 
 */
public interface ReportService {

	StructureReport analyzeStructure() throws Exception;

	/**
	 * Generate product's report of deliver time.
	 * 
	 * @return
	 */
	DeliveryTimeReport analyzeDeliveryTime(String accountId, String brand)
			throws Exception;

	/**
	 * Generate a integration report including size report, category report,
	 * total amount etc.
	 * 
	 * @param accountId
	 * @return
	 */
	IntegrationReport analyzeIntegration(String accountId, String brand)
			throws Exception;

	
	/**
	 * Generate a season-category report list
	 * 
	 * @param accountId
	 * @return
	 */
	List<SeasonCategoryReport> analyzeSeasonCategory(String accountId,
			String brand) throws Exception;

	List<SeasonCategoryReport> analyzeSeasonBigType(String id, String brand)
			throws Exception;

	List<SeasonCategoryReport> analyzeSeasonColor(String id, String brand)
			throws Exception;

	List<BrandBigtypeReport> analyzeBrandBigtype(String accountId)
			throws Exception;

	BrandReport analyzeBrand(String accountId) throws Exception;

}
