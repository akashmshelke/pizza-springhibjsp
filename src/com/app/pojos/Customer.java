package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "PIZZA_Customers")
public class Customer {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer customerId;

	@Column(name = "Name", nullable = false, length = 30)
	private String name;

	@Column(name = "Password", nullable = false, length = 30)
	private String password;

	@Column(name = "Mobile", nullable = false, length = 15)
	private String mobile;

	@Column(name = "Address", nullable = false, length = 60)
	private String address;

	@Column(name = "Email", unique = true, nullable = false, length = 40)
	private String email;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Order> orderList;

	public Customer() {
	}

	public Customer(Integer customerId, String name, String password, String mobile, String address, String email) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
		this.email = email;
	}

	public Customer(String password, String email) {
		super();
		this.password = password;
		this.email = email;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", password=" + password + ", mobile=" + mobile
				+ ", address=" + address + ", email=" + email + "]";
	}
}
