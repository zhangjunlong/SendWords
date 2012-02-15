package com.openthinks.woms.product;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;

/**
 * A color description with its different sizes
 * 
 * @author Zhang Junlong
 * 
 */
@Entity
public class ColorSizesComposition {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	@OrderBy("name ASC")
	private Color color;

	@ManyToMany(fetch = FetchType.EAGER)
	@OrderBy("name ASC")
	private Set<Size> sizes = new HashSet<Size>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Set<Size> getSizes() {
		return sizes;
	}

	public void setSizes(Set<Size> sizes) {
		this.sizes = sizes;
	}

}
