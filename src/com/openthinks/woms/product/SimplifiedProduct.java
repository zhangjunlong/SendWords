package com.openthinks.woms.product;

/**
 * Simplified product for displaying use
 * 
 * @author Zhang Junlong
 * 
 */
public class SimplifiedProduct {
	public long id;

	public String brand;

	public String styleNo;

	public String name;

	public SimplifiedProduct(long id, String brand, String styleNo, String name) {
		super();
		this.id = id;
		this.brand = brand;
		this.styleNo = styleNo;
		this.name = name;
	}

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

	public String getStyleNo() {
		return styleNo;
	}

	public void setStyleNo(String styleNo) {
		this.styleNo = styleNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
