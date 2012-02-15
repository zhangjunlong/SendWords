package com.openthinks.woms.order;

import java.util.Collection;
import java.util.List;

import com.openthinks.dao.SectionResult;
import com.openthinks.woms.product.Product;
import com.openthinks.woms.product.Season;
import com.openthinks.woms.product.Style;

/**
 * OrderModel
 * 
 * @author Zhang Wenlong
 * 
 */
public class OrderModel {
	private Product product;

	private SectionResult<Object> products;

	private String notepadKeyword;

	private List<OrderForm> orders;

    private Collection<Style> styles;
    
    private Collection<Season> seasons;
	
	private int orderType;
	
	private String querySearchType;
	
	private String productSeason;
	
	private String productStyle;
	
	private int size;

	private int section;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

    public SectionResult<Object> getProducts() {
        return products;
    }

    public void setProducts(SectionResult<Object> products) {
        this.products = products;
    }

    public String getNotepadKeyword() {
		return notepadKeyword;
	}

	public void setNotepadKeyword(String notepadKeyword) {
		this.notepadKeyword = notepadKeyword;
	}

	public List<OrderForm> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderForm> orders) {
        this.orders = orders;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }
    
	public String getQuerySearchType() {
		return querySearchType;
	}

	public void setQuerySearchType(String querySearchType) {
		this.querySearchType = querySearchType;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}

	public Collection<Style> getStyles() {
		return styles;
	}

	public void setStyles(Collection<Style> styles) {
		this.styles = styles;
	}

	public Collection<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(Collection<Season> seasons) {
        this.seasons = seasons;
    }

    public String getProductSeason() {
		return productSeason;
	}

	public void setProductSeason(String productSeason) {
		this.productSeason = productSeason;
	}

	public String getProductStyle() {
		return productStyle;
	}

	public void setProductStyle(String productStyle) {
		this.productStyle = productStyle;
	}

}
