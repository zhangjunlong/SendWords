package com.openthinks.woms.order;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.openthinks.woms.account.Account;
import com.openthinks.woms.product.Color;
import com.openthinks.woms.product.Product;
import com.openthinks.woms.product.Size;

/**
 * Order
 * 
 * @author Zhang Junlong
 * 
 */
@Entity
@Table(name="productOrder")
public class OrderForm {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	private Color color;

	@ManyToOne
	private Size size;

	private int quantity;

	@ManyToOne(cascade = CascadeType.REFRESH)
	private Product product;

	@ManyToOne
	private Account account;

	private double amount;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate = new Date();

	public OrderForm() {
        super();
    }

    public OrderForm(long id, Color color, Size size, int quantity) {
        super();
        this.id = id;
        this.color = color;
        this.size = size;
        this.quantity = quantity;
    }

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	
}
