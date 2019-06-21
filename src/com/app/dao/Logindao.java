package com.app.dao;

import com.app.pojos.Customer;

public interface Logindao {

	/*public void open();

	public void close();*/

	public Customer registerCustomer(Customer customer);

	public Customer validateUser(String email, String password);

	public Customer fetchCustomer(Customer customer);
	
	public String updateCustomer(Customer customer);

	
	public Customer fetchCustomerByEmail(String email);
	
	public Customer fetchCustomerById(int cid);

}
