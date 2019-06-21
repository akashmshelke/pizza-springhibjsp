package com.app.service;

import com.app.pojos.Customer;

public interface Customerservice {

	public Customer insertCustomer(Customer customer);

	public Customer getCustomer(Customer customer);

	public Customer getCustomerByEmail(String email);
	
	public String updateCustomer(Customer customer);
	
	public Customer getCustomerById(int cid);


}
