package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PIZZA_ITEMS")
public class Item {
	
	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false, length = 11)
	private int ItemId;
	
	@Column(name = "Name", nullable = false, length = 40)
	private String name;
	
	@Column(name = "Type", nullable = false, length = 100)
	private String type;
	
	@Column(name = "Category", nullable = false, length = 30)
	private String category;
	
	@Column(name = "Description", nullable = false, length = 120)
	private String description;
	
	
	@OneToMany(mappedBy="item",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<ItemPrice> priceList;
	
	public Item (){}

	

	public Item(int itemId, String name, String type, String category, String description, List<ItemPrice> priceList) {
		super();
		ItemId = itemId;
		this.name = name;
		this.type = type;
		this.category = category;
		this.description = description;
		this.priceList = priceList;
	}

	public int getItemId() {
		return ItemId;
	}

	public void setItemId(int itemId) {
		ItemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ItemPrice> getPriceList() {
		return priceList;
	}

	public void setPriceList(List<ItemPrice> priceList) {
		this.priceList = priceList;
	}

	@Override
	public String toString() {
		return "Item [ItemId=" + ItemId + ", name=" + name + ", type=" + type + ", category=" + category
				+ ", description=" + description + ", priceList=" + priceList + "]";
	}

}
