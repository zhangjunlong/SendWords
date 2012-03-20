package com.openthinks.woms.profile;

/**
 * Cloth query model
 * 
 * @author Zhang Junlong
 * 
 */
public class QueryParameters {
	private String accountId = "%";

	private String sn = "%";

	private String brand = "%";

	private String category = "%";

	private String season = "%";

	private int section = 1;

	private String salesPromotion = "%";

	private boolean ordered = false;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getSn() {
		if (null == sn || "".equals(sn))
			sn = "%";

		return sn;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getCategory() {
		if (null == category || "".equals(category))
			category = "%";

		return category;
	}

	public void setCategory(String category) {

		this.category = category;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		if (null == season || "".equals(season))
			season = "%";

		this.season = season;
	}

	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}

	public String getSalesPromotion() {
		return salesPromotion;
	}

	public void setSalesPromotion(String salesPromotion) {
		if (null == salesPromotion || "".equals(salesPromotion))
			salesPromotion = "%";

		this.salesPromotion = salesPromotion;
	}

	public boolean isOrdered() {
		return ordered;
	}

	public void setOrdered(boolean ordered) {
		this.ordered = ordered;
	}

}
