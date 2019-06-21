package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PIZZA_OrderDetails")
public class OrderDetails {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int detailsId;

	@ManyToOne
	@JoinColumn(name = "OrderId")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "PRICEID")
	private ItemPrice itemprice;

	public OrderDetails() {

	}

	public OrderDetails(int detailsId, Order order, ItemPrice itemprice) {
		super();
		this.detailsId = detailsId;
		this.order = order;
		this.itemprice = itemprice;
	}

	public int getDetailsId() {
		return detailsId;
	}

	public void setDetailsId(int detailsId) {
		this.detailsId = detailsId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public ItemPrice getItemprice() {
		return itemprice;
	}

	public void setItemprice(ItemPrice itemprice) {
		this.itemprice = itemprice;
	}

	@Override
	public String toString() {
		return "OrderDetails [detailsId=" + detailsId + "]";
	}


}
