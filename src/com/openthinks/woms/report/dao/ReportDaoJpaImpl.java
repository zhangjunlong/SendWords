package com.openthinks.woms.report.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import com.openthinks.dao.GenericJpaDaoBean;
import com.openthinks.woms.order.OrderForm;
import com.openthinks.woms.report.SeriesReportItem;
import com.openthinks.woms.report.BrandBigtypeReportItem;
import com.openthinks.woms.report.BrandReportItem;
import com.openthinks.woms.report.ColorReportItem;
import com.openthinks.woms.report.QuantityByCategory;
import com.openthinks.woms.report.SeasonCategoryReportItem;
import com.openthinks.woms.report.SeasonReportItem;
import com.openthinks.woms.report.StyleReportItem;

/**
 * Implementation of the ReportDao using JPA
 * 
 * @author Zhang Junlong
 * 
 */
public class ReportDaoJpaImpl extends GenericJpaDaoBean<OrderForm, String>
		implements ReportDao {

	public ReportDaoJpaImpl() {
		super(OrderForm.class);
	}

	@Override
	public long countOrderedProduct(String deliveryTime, String accountId,
			String brand) {
		String sql = "SELECT COUNT(1) FROM (SELECT 1 FROM Order of, Product p WHERE of.product_id=p.id AND deliveryTime = ?0 AND p.brand LIKE ?1 AND of.account_username LIKE ?2 GROUP BY p.id) temp";

		Query query = em.createNativeQuery(sql);
		query.setParameter(0, deliveryTime);
		query.setParameter(1, brand);
		query.setParameter(2, accountId);

		List res = query.getResultList();
		long count = 0;
		if (null != res && res.size() > 0) {
			count = ((BigInteger) res.get(0)).longValue();
		}

		return count;
	}

	@Override
	public long countOrderedSn(String deliveryTime, String accountId,
			String brand) {
		String sql = "SELECt COUNT(1) FROM (SELECT 1 FROM Order of,Product p WHERE of.product_id=p.id AND deliveryTime = ?0 AND p.brand LIKE ?1 AND of.account_username LIKE ?2 GROUP BY p.sn) temp";

		Query query = em.createNativeQuery(sql);
		query.setParameter(0, deliveryTime);
		query.setParameter(1, brand);
		query.setParameter(2, accountId);

		List res = query.getResultList();
		long count = 0;
		if (null != res && res.size() > 0) {
			count = ((BigInteger) res.get(0)).longValue();
		}
		return count;
	}

	@Override
	public long countProduct(String deliveryTime, String brand) {
		String sql = "SELECT COUNT(1) FROM Product WHERE deliveryTime = ?0 AND brand LIKE ?1";
		Query query = em.createNativeQuery(sql);
		query.setParameter(0, deliveryTime);
		query.setParameter(1, brand);

		List res = query.getResultList();

		long count = 0;
		if (null != res && res.size() > 0) {
			count = ((BigInteger) res.get(0)).longValue();
		}

		return count;
	}

	@Override
	public long countSn(String deliveryTime, String brand) {
		String sql = "SELECT COUNT(1) FROM Product WHERE deliveryTime= ?0 AND brand LIKE ?1 GROUP BY sn";

		Query query = em.createNativeQuery(sql);
		query.setParameter(0, deliveryTime);
		query.setParameter(1, brand);

		List res = query.getResultList();

		long count = 0;
		if (null != res && res.size() > 0) {
			count = res.size();
		}

		return count;
	}

	@Override
	public List<String> readAllDeliveryTime(String brand) {
		String sql = "SELECT DISTINCT deliveryTime FROM Product WHERE brand LIKE ?0 ORDER BY deliveryTime";

		Query query = em.createNativeQuery(sql);
		query.setParameter(0, brand);

		List resList = query.getResultList();

		List<String> deliveryTimeList = new ArrayList<String>();
		for (int i = 0; i < resList.size(); i++) {
			Date deliveryTime = (Date) resList.get(i);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String strDeliveryTime = sdf.format(deliveryTime);

			deliveryTimeList.add(strDeliveryTime);
		}
		return deliveryTimeList;
	}

	@Override
	public List sumQuantity(String accountId, String brand) {
		String sql = "SELECT SUM(o.quantity),SUM(o.quantityO),SUM(o.quantityS),SUM(o.quantityM),SUM(o.quantityL),SUM(o.quantityXL),SUM(o.quantityXXL),SUM(amount) FROM Order o,Product p WHERE o.product_id=p.id AND o.account_userName LIKE ?0 AND p.brand LIKE ?1";

		Query query = em.createNativeQuery(sql);
		query.setParameter(0, accountId);
		query.setParameter(1, brand);

		List res = query.getResultList();

		return res;
	}

	@Override
	public List<QuantityByCategory> sumQuantityByCategory(String accountid,
			String brand) {

		String sql = "SELECT category,SUM(o.quantity),bigtype FROM Order o, Product p WHERE o.product_id=p.id AND o.account_userName LIKE ?0 AND p.brand LIKE ?1 GROUP BY category";

		Query query = em.createNativeQuery(sql);
		query.setParameter(0, accountid);
		query.setParameter(1, brand);

		List res = query.getResultList();

		List<QuantityByCategory> qclist = new ArrayList<QuantityByCategory>();
		for (int i = 0; i < res.size(); i++) {
			QuantityByCategory qbc = new QuantityByCategory();

			Object[] resArray = (Object[]) res.get(i);

			qbc.setCategory(resArray[0] == null ? "" : (String) resArray[0]);
			BigDecimal qSum = resArray[1] == null ? new BigDecimal("0")
					: (BigDecimal) resArray[1];
			qbc.setQuantity(qSum.longValue());

			qbc.setBigtype(resArray[2] == null ? "" : (String) resArray[2]);

			qclist.add(qbc);
		}

		return qclist;

	}

	@Override
	public List<BrandReportItem> sumQuantityByBrand(String accountId) {
		String sql = "SELECT brand,SUM(quantity),SUM(amount) FROM (SELECT season,brand,bigtype,quantity,amount FROM (SELECT * FROM orderform WHERE account_username LIKE ?0) o RIGHT JOIN product p ON o.product_id = p.id) po  GROUP BY brand";

		Query query = em.createNativeQuery(sql);
		query.setParameter(0, accountId);

		List res = query.getResultList();

		List<BrandReportItem> qclist = new ArrayList<BrandReportItem>();
		for (int i = 0; i < res.size(); i++) {
			BrandReportItem qbc = new BrandReportItem();

			Object[] resArray = (Object[]) res.get(i);

			qbc.setBrand(resArray[0] == null ? "" : (String) resArray[0]);
			BigDecimal qSum = resArray[1] == null ? new BigDecimal("0")
					: (BigDecimal) resArray[1];
			qbc.setQuantity(qSum.longValue());

			Double qAmo = resArray[2] == null ? new Double("0")
					: (Double) resArray[2];
			qbc.setAmount(qAmo.longValue());

			qclist.add(qbc);
		}

		return qclist;
	}

	@Override
	public List<SeasonCategoryReportItem> countQuantityBySeasonWithBigType(
			String accountId, String brand) {
		return this.countQuanitityWithPairOfProperties(accountId, "season",
				"bigType", brand);
	}

	@Override
	public List<SeasonCategoryReportItem> countQuantityBySeasonWithColor(
			String accountId, String brand) {
		return this.countQuanitityWithPairOfProperties(accountId, "season",
				"color", brand);
	}

	@Override
	public List<SeasonCategoryReportItem> countQuantityBySeasonWithCategory(
			String accountId, String brand) {
		return this.countQuanitityWithPairOfProperties(accountId, "season",
				"category", brand);
	}

	@Override
	public List<BrandBigtypeReportItem> sumQuantityWithBrandBigtype(
			String accountId) {

		String sql = "SELECT brand,bigtype,SUM(quantity),SUM(amount) FROM (SELECT brand,bigtype,quantity,amount FROM (SELECT * FROM orderform WHERE account_username LIKE ?0) o RIGHT JOIN product p ON o.product_id = p.id ) po GROUP BY brand,bigtype";

		Query query = em.createNativeQuery(sql);
		query.setParameter(0, accountId);

		List qResList = query.getResultList();
		List<BrandBigtypeReportItem> bbItems = new ArrayList<BrandBigtypeReportItem>();
		for (int i = 0; i < qResList.size(); i++) {
			BrandBigtypeReportItem scri = new BrandBigtypeReportItem();

			Object[] resArray = (Object[]) qResList.get(i);

			scri.setBrand((String) resArray[0]);
			scri.setBigType((String) resArray[1]);

			BigDecimal qSum = resArray[2] == null ? new BigDecimal("0")
					: (BigDecimal) resArray[2];
			scri.setQuantity(qSum.longValue());

			Double aSum = resArray[3] == null ? new Double(0)
					: (Double) resArray[3];

			scri.setAmount(aSum.doubleValue());

			bbItems.add(scri);
		}

		return bbItems;
	}

	private List<SeasonCategoryReportItem> countQuanitityWithPairOfProperties(
			String accountId, String prop1, String prop2, String brand) {
		String special = prop1;
		if (prop1.equals("brand"))
			special = "p.id";

		String sql = "SELECT "
				+ prop1
				+ ","
				+ prop2
				+ ",COUNT(1),COUNT(quantity) FROM (SELECT "
				+ special
				+ ",brand,"
				+ prop2
				+ ",quantity FROM (SELECT * FROM orderform WHERE account_username LIKE ?0) o RIGHT JOIN product p ON o.product_id = p.id WHERE brand LIKE ?1) po  GROUP BY "
				+ prop1 + "," + prop2;

		Query query = em.createNativeQuery(sql);
		query.setParameter(0, accountId);
		query.setParameter(1, brand);

		List qResList = query.getResultList();

		List<SeasonCategoryReportItem> scrItems = new ArrayList<SeasonCategoryReportItem>();
		for (int i = 0; i < qResList.size(); i++) {
			SeasonCategoryReportItem scri = new SeasonCategoryReportItem();

			Object[] resArray = (Object[]) qResList.get(i);

			scri.setSeason((String) resArray[0]);
			scri.setCategory((String) resArray[1]);
			scri.setTotalCount(((BigInteger) resArray[2]).longValue());
			scri.setOrderedCount(((BigInteger) resArray[3]).longValue());

			scrItems.add(scri);
		}

		return scrItems;
	}
}
