package com.openthinks.woms.report.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.openthinks.woms.account.Account;
import com.openthinks.woms.account.OrderTask;
import com.openthinks.woms.account.dao.AccountDao;
import com.openthinks.woms.report.SeriesReport;
import com.openthinks.woms.report.SeriesReportItem;
import com.openthinks.woms.report.BrandBigtypeReport;
import com.openthinks.woms.report.BrandBigtypeReportItem;
import com.openthinks.woms.report.BrandReport;
import com.openthinks.woms.report.BrandReportItem;
import com.openthinks.woms.report.DeliveryTimeReport;
import com.openthinks.woms.report.DeliveryTimeReportItem;
import com.openthinks.woms.report.IntegrationReport;
import com.openthinks.woms.report.QuantityByCategory;
import com.openthinks.woms.report.SeasonCategoryReport;
import com.openthinks.woms.report.SeasonCategoryReportItem;
import com.openthinks.woms.report.SeasonReport;
import com.openthinks.woms.report.SeasonReportItem;
import com.openthinks.woms.report.StructureReport;
import com.openthinks.woms.report.StyleReport;
import com.openthinks.woms.report.StyleReportItem;
import com.openthinks.woms.report.dao.ReportDao;
import com.openthinks.woms.util.MemoryClass;

/**
 * An implementation of ReportService interface
 * 
 * @author Zhang Junlong
 * 
 */
public class ReportServiceImpl implements ReportService {

	private AccountDao accountDao;

	private ReportDao reportDao;

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public void setReportDao(ReportDao reportDao) {
		this.reportDao = reportDao;
	}

	@Override
	public StructureReport analyzeStructure() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeliveryTimeReport analyzeDeliveryTime(String accountId, String brand)
			throws Exception {
		DeliveryTimeReport dtr = new DeliveryTimeReport();
		List<String> dtList = reportDao.readAllDeliveryTime(brand);

		List<DeliveryTimeReportItem> items = new ArrayList<DeliveryTimeReportItem>();
		for (String deliveryTime : dtList) {
			DeliveryTimeReportItem dtri = new DeliveryTimeReportItem();
			dtri.setDeliveryTime(deliveryTime);
			dtri.setTotalStyle(reportDao.countProduct(deliveryTime, brand));
			dtri.setTotalStyleOrdered(reportDao.countOrderedProduct(
					deliveryTime, accountId, brand));
			dtri.setTotalProduct(reportDao.countSn(deliveryTime, brand));
			dtri.setTotalProductOrdered(reportDao.countOrderedSn(deliveryTime,
					accountId, brand));

			items.add(dtri);
		}

		dtr.setDeliveryTimeReportItems(items);

		return dtr;
	}

	@Override
	public IntegrationReport analyzeIntegration(String accountId, String brand)
			throws Exception {
		IntegrationReport ir = new IntegrationReport();

		List res = reportDao.sumQuantity(accountId, brand);
		if (null != res && res.size() > 0) {
			Object[] object = (Object[]) res.get(0);
			BigDecimal l = (BigDecimal) object[4];
			BigDecimal o = (BigDecimal) object[1];
			if (null == o)
				o = new BigDecimal(0);
			BigDecimal s = (BigDecimal) object[2];
			if (null == s)
				s = new BigDecimal(0);
			BigDecimal m = (BigDecimal) object[3];
			if (null == m)
				m = new BigDecimal(0);
			if (null == l)
				l = new BigDecimal(0);
			BigDecimal xl = (BigDecimal) object[5];
			if (null == xl)
				xl = new BigDecimal(0);
			BigDecimal xxl = (BigDecimal) object[6];
			if (null == xxl)
				xxl = new BigDecimal(0);

			BigDecimal all = (BigDecimal) object[0];
			BigDecimal totalCount = new BigDecimal("-1");
			if (null == all) {
				totalCount = new BigDecimal(0);
				all = new BigDecimal(1);
			} else {
				totalCount = all;
			}

			BigDecimal hundred = new BigDecimal("100");
			if (!(0 == all.longValue())) {
				ir.setQuantityLCount(l.divide(all, 3, BigDecimal.ROUND_HALF_UP)
						.multiply(hundred).doubleValue());
				ir.setQuantityOCount(o.divide(all, 3, BigDecimal.ROUND_HALF_UP)
						.multiply(hundred).doubleValue());
				ir.setQuantitySCount(s.divide(all, 3, BigDecimal.ROUND_HALF_UP)
						.multiply(hundred).doubleValue());
				ir.setQuantityMCount(m.divide(all, 3, BigDecimal.ROUND_HALF_UP)
						.multiply(hundred).doubleValue());
				ir.setQuantityXLCount(xl
						.divide(all, 3, BigDecimal.ROUND_HALF_UP)
						.multiply(hundred).doubleValue());
				ir.setQuantityXXLCount(xxl
						.divide(all, 3, BigDecimal.ROUND_HALF_UP)
						.multiply(hundred).doubleValue());

			}
			ir.setQuantityCount(totalCount.longValue());

			Double tAmount = ((Double) object[7]);
			if (null == tAmount)
				tAmount = new Double(0);
			ir.setTotalAmount(tAmount);
		}

		List<QuantityByCategory> qclist = reportDao.sumQuantityByCategory(
				accountId, brand);

		for (int i = 0; qclist != null && i < qclist.size(); i++) {
			if (0 != ir.getQuantityCount()) {
				BigDecimal qcQuantity = new BigDecimal(qclist.get(i)
						.getQuantity() * 100);

				BigDecimal tQuantity = new BigDecimal(ir.getQuantityCount());

				double percentage = qcQuantity.divide(tQuantity, 1,
						BigDecimal.ROUND_HALF_UP).doubleValue();

				qclist.get(i).setPercentage(percentage);
			}

		}

		ir.setCategorySumList(qclist);

		Account account = accountDao.read(accountId);

		return ir;
	}

	@Override
	public BrandReport analyzeBrand(String accountId) throws Exception {
		BrandReport brandReport = new BrandReport();

		List<BrandReportItem> items = reportDao.sumQuantityByBrand(accountId);

		brandReport.setBrandReportItems(items);

		int amountSum = 0;
		int quantitySum = 0;
		for (BrandReportItem item : items) {
			amountSum += item.getAmount();
			quantitySum += item.getQuantity();
		}

		BigDecimal hundred = new BigDecimal("100");

		for (BrandReportItem item : items) {
			if (quantitySum != 0) {

				item.setQuantityPercentage(new BigDecimal(item.getQuantity())
						.divide(new BigDecimal(quantitySum), 3,
								BigDecimal.ROUND_HALF_UP).multiply(hundred)
						.doubleValue());
			} else {
				item.setQuantityPercentage(0);
			}

			if (amountSum != 0) {
				item.setAmountPercentage(new BigDecimal(item.getAmount())
						.divide(new BigDecimal(amountSum), 3,
								BigDecimal.ROUND_HALF_UP).multiply(hundred)
						.doubleValue());
			} else {
				item.setAmountPercentage(0);
			}
		}

		return brandReport;

	}

	@Override
	public List<SeasonCategoryReport> analyzeSeasonCategory(String accountId,
			String brand) throws Exception {

		List<SeasonCategoryReportItem> sciList = reportDao
				.countQuantityBySeasonWithCategory(accountId, brand);

		return wrapSeasonAnalyzedResult(sciList);
	}

	@Override
	public List<SeasonCategoryReport> analyzeSeasonBigType(String accountId,
			String brand) throws Exception {

		List<SeasonCategoryReportItem> sciList = reportDao
				.countQuantityBySeasonWithBigType(accountId, brand);

		return wrapSeasonAnalyzedResult(sciList);
	}

	@Override
	public List<SeasonCategoryReport> analyzeSeasonColor(String accountId,
			String brand) throws Exception {

		List<SeasonCategoryReportItem> sciList = reportDao
				.countQuantityBySeasonWithColor(accountId, brand);

		return wrapSeasonAnalyzedResult(sciList);
	}

	@Override
	public List<BrandBigtypeReport> analyzeBrandBigtype(String accountId)
			throws Exception {

		List<BrandBigtypeReportItem> sciList = reportDao
				.sumQuantityWithBrandBigtype(accountId);

		List<BrandBigtypeReport> scReportList = new ArrayList<BrandBigtypeReport>();

		String cBrand = null;
		BrandBigtypeReport scReport = new BrandBigtypeReport();

		for (int i = 0; i < sciList.size(); i++) {
			BrandBigtypeReportItem scri = sciList.get(i);

			if (null == cBrand || cBrand.equals(scri.getBrand())) {
				cBrand = scri.getBrand();
				scReport.setBrand(scri.getBrand());
				List<BrandBigtypeReportItem> itemList = scReport
						.getBrandBigtypeReportItems();
				itemList.add(scri);

				if (i == sciList.size() - 1) {
					scReportList.add(scReport);
					scReport = new BrandBigtypeReport();
				}
			} else if (!cBrand.equals(scri.getBrand())) {
				cBrand = scri.getBrand();
				scReportList.add(scReport);

				scReport = new BrandBigtypeReport();
				i--;
			}
		}

		scReport.setBrandBigtypeReportItems(sciList);

		return scReportList;
	}

	/**
	 * @param scReportList
	 * @param sciList
	 * @return
	 */
	private List<SeasonCategoryReport> wrapSeasonAnalyzedResult(
			List<SeasonCategoryReportItem> sciList) {

		List<SeasonCategoryReport> scReportList = new ArrayList<SeasonCategoryReport>();

		String cSeason = null;
		SeasonCategoryReport scReport = new SeasonCategoryReport();

		for (int i = 0; i < sciList.size(); i++) {
			SeasonCategoryReportItem scri = sciList.get(i);

			if (null == cSeason || cSeason.equals(scri.getSeason())) {
				cSeason = scri.getSeason();
				scReport.setSeason(scri.getSeason());
				List<SeasonCategoryReportItem> itemList = scReport
						.getSeasonCategoryReportItems();
				itemList.add(scri);

				if (i == sciList.size() - 1) {
					scReportList.add(scReport);
					scReport = new SeasonCategoryReport();
				}
			} else if (!cSeason.equals(scri.getSeason())) {
				cSeason = scri.getSeason();
				scReportList.add(scReport);

				scReport = new SeasonCategoryReport();
				i--;
			}
		}

		scReport.setSeasonCategoryReportItems(sciList);

		return scReportList;
	}
}
