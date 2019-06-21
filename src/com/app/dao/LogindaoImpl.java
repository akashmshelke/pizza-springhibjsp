package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Customer;

@Repository
public class LogindaoImpl implements Logindao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Customer registerCustomer(Customer customer) {

		System.out.println("######" + customer);
		sf.getCurrentSession().save(customer);

		return customer;
	}

	@Override
	public Customer validateUser(String email, String password) {

		String query = "select customer from Customer customer where customer.email=:eMail and customer.password=:pass ";
		Customer customer = (Customer) sf.getCurrentSession().createQuery(query).setParameter("eMail", email)
				.setParameter("pass", password).uniqueResult();

		return customer;

	}

	@Override
	public Customer fetchCustomer(Customer customer) {

		String query = "select customer from Customer customer where customer.email=:eMail and customer.password=:pass";
		customer = (Customer) sf.getCurrentSession().createQuery(query).setParameter("eMail", customer.getEmail())
				.setParameter("pass", customer.getPassword()).uniqueResult();

		return customer;
	}

	@Override
	public Customer fetchCustomerByEmail(String email) {

		String query = "select cust from Customer cust where cust.email=:eMail";
		Customer customer = (Customer) sf.getCurrentSession().createQuery(query).setParameter("eMail", email)
				.uniqueResult();
		return customer;
	}

	@Override
	public String updateCustomer(Customer customer) {

		sf.getCurrentSession().update(customer);
		return "updated Successfully";
	}

	@Override
	public Customer fetchCustomerById(int cid) {

		return (Customer) sf.getCurrentSession().get(Customer.class, cid);
	}

}
