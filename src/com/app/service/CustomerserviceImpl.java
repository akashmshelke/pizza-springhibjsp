package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.Logindao;
import com.app.pojos.Customer;

@Service
@Transactional
public class CustomerserviceImpl implements Customerservice {

	@Autowired
	private Logindao logindao;

	@Override
	public Customer insertCustomer(Customer customer) {

		return logindao.registerCustomer(customer);
	}

	@Override
	public Customer getCustomer(Customer customer) {

		return logindao.fetchCustomer(customer);
	}

	@Override
	public Customer getCustomerByEmail(String email) {

		Customer cust = logindao.fetchCustomerByEmail(email);

		return cust;
	}

	@Override
	public String updateCustomer(Customer customer) {

		return logindao.updateCustomer(customer);
	}

	@Override
	public Customer getCustomerById(int cid) {

		return logindao.fetchCustomerById(cid);
	}

}
