package com.app.pojos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PIZZA_Pricing")
public class ItemPrice {

	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false, length = 11)
	private int pricingId;

	@Column(name = "SIZES", nullable = false, length = 20)
	private String sizes;

	@Column(name = "Price", nullable = false)
	private Double price;

	@ManyToOne
	@JoinColumn(name = "ITEMID")
	private Item item;

	@OneToMany(mappedBy="itemprice")
	private List<OrderDetails> orderDetailsList1;

	public ItemPrice() {
	}

	public ItemPrice(int pricingId, String sizes, Double price) {
		super();
		this.pricingId = pricingId;

		this.sizes = sizes;
		this.price = price;
	}

	public int getPricingId() {
		return pricingId;
	}

	public void setPricingId(int pricingId) {
		this.pricingId = pricingId;
	}

	public String getSizes() {
		return sizes;
	}

	public void setSizes(String sizes) {
		this.sizes = sizes;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public List<OrderDetails> getOrderDetailsList1() {
		return orderDetailsList1;
	}

	public void setOrderDetailsList1(List<OrderDetails> orderDetailsList1) {
		this.orderDetailsList1 = orderDetailsList1;
	}

	@Override
	public String toString() {
		return "ItemPrice [pricingId=" + pricingId + ", sizes=" + sizes + ", price=" + price + "]";
	}

}
