package com.openthinks.woms.product;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

/**
 * Product for ordering
 * 
 * @author Zhang Junlong
 * 
 */
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	private Brand brand;

	@Column(length = 10, unique = true)
	private String model;

	@Column(length = 30)
	private String name;

	@Column(length = 10)
	private String brevityCode;

	@Column(precision = 12, scale = 2)
	private double orderingPrice;

	@Column(precision = 12, scale = 2)
	private double sellingPrice;

	@Column(precision = 12, scale = 2)
	private double originalPrice;

	private boolean promotional;

	@Column(length = 128)
	private String code;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@OrderBy("id")
	Set<ColorSizesComposition> colorSizesCompositions = new HashSet<ColorSizesComposition>();

	@Column(length = 128)
	private String picture;

	@ManyToOne
	private Season season;

	@ManyToOne
	private Category category;

	@ManyToOne
	private Series series;

	@ManyToOne
	private Style style;

	@OneToMany(fetch = FetchType.EAGER)
	private Set<Product> matchProduct;

	@Column(length = 100)
	private String remark;

	@Transient
	private Long orderCount;

	public Product() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
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

	public String getModel() {
		return model;
	}

	public void setModel(String styleNo) {
		this.model = styleNo;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Set<ColorSizesComposition> getColorSizesCompositions() {
		return colorSizesCompositions;
	}

	public void setColorSizesCompositions(
			Set<ColorSizesComposition> colorSizesCompositions) {
		this.colorSizesCompositions = colorSizesCompositions;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Product> getMatchProduct() {
		return matchProduct;
	}

	public void setMatchProduct(Set<Product> matchProduct) {
		this.matchProduct = matchProduct;
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

	public String getBrevityCode() {
		return brevityCode;
	}

	public void setBrevityCode(String brevityCode) {
		this.brevityCode = brevityCode;
	}

	public Series getSeries() {
		return series;
	}

	public void setSeries(Series series) {
		this.series = series;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

}
