package com.openthinks.woms.product;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

/**
 * Product for ordering
 * 
 * @author Zhang Junlong
 * 
 */
@Entity
@SqlResultSetMapping(name = "ProductResult", entities = @EntityResult(entityClass = ProductResult.class, discriminatorColumn = "TYPE", fields = {
		@FieldResult(name = "id", column = "id"),
		@FieldResult(name = "model", column = "model"),
        @FieldResult(name = "name", column = "name"),
        @FieldResult(name = "brevityCode", column = "brevityCode"),
		@FieldResult(name = "brand", column = "brand"),
		@FieldResult(name = "orderingPrice", column = "orderingPrice"),
		@FieldResult(name = "sellingPrice", column = "sellingPrice"),
		@FieldResult(name = "originalPrice", column = "originalPrice"),
		@FieldResult(name = "promotional", column = "promotional"),
		@FieldResult(name = "code", column = "code"),
        @FieldResult(name = "seasonId", column = "seasonId"),
        @FieldResult(name = "season", column = "season"),
		@FieldResult(name = "category", column = "category"),
		@FieldResult(name = "series", column = "series"),
		@FieldResult(name = "styleId", column = "styleId"),
		@FieldResult(name = "style", column = "style"),
		@FieldResult(name = "remark", column = "remark"),
		@FieldResult(name = "orderCount", column = "orderCount") }))
public class ProductResult {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String brand;

	private String model;

	private String name;
	
	private String brevityCode;

	private double orderingPrice;

	private double sellingPrice;

	private double originalPrice;

	private boolean promotional;

	private String code;
	
	private String category;

    private String styleId;
    
    private String style;
    
    private String seasonId;
    
    private String season;

	private String series;

	private String remark;

	private Long orderCount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String styleNo) {
		this.model = styleNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getOrderingPrice() {
		return orderingPrice;
	}

	public void setOrderingPrice(double orderingPrice) {
		this.orderingPrice = orderingPrice;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public boolean isPromotional() {
		return promotional;
	}

	public void setPromotional(boolean promotional) {
		this.promotional = promotional;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(String seasonId) {
        this.seasonId = seasonId;
    }

    public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(Long orderCount) {
		this.orderCount = orderCount;
	}

	public String getStyleId() {
		return styleId;
	}

	public void setStyleId(String styleId) {
		this.styleId = styleId;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getBrevityCode() {
		return brevityCode;
	}

	public void setBrevityCode(String brevityCode) {
		this.brevityCode = brevityCode;
	}

}
