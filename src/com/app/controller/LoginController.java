package com.app.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Customer;
import com.app.service.Customerservice;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	private Customerservice customerservice;

	@RequestMapping("/login")
	public String login(ModelMap map) {

		return "Customer/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processLogin(ModelMap map, @Valid Customer customer, BindingResult result, HttpSession hs) {

		Customer cust = customerservice.getCustomer(customer);
		if (cust == null) {
			map.addAttribute("message", "*Please enter valid email or password...");
			return "Customer/login";
		} else if (customer.getEmail().equals("admin@sunbeaminfo.com")) {

			hs.setAttribute("customer", cust);
			return "redirect:/admindashboard";
		} else {
			hs.setAttribute("customer", cust);
			return "redirect:/menu";
		}

	}

	@RequestMapping("/admindashboard")
	public String admindashboard() {

		return "admin/admindashboard";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession hs) {

		hs.invalidate();
		return "Customer/logout";
	}

	@RequestMapping("/register")
	public String register() {

		return "Customer/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(ModelMap map, @Valid Customer customer, BindingResult result, HttpSession session) {

		Customer cust = customerservice.getCustomerByEmail(customer.getEmail());

		if (cust == null) {
			Customer c = customerservice.insertCustomer(customer);
			map.addAttribute("welmessage", "Welcome" + c.getName() + "...Please login in to proceed");
			return "Customer/login";
		} else {

			map.addAttribute("emailexist", "*Email Already exists...");
			return "Customer/register";

		}

	}

	@RequestMapping("/fetchcustomer")
	public String fetchCustomer() {

		return "index";
	}

	@RequestMapping(value = "/fetchcustomer", method = RequestMethod.GET)
	public String fetchCustomer(ModelMap map, @Valid Customer customer, BindingResult result, HttpSession session) {

		customerservice.getCustomer(customer);

		return "Customer/profile";
	}

	@RequestMapping("/profile")
	public String fetchProfile(@RequestParam int cid, Model map,HttpSession hs) {

		map.addAttribute("customer", customerservice.getCustomerById(cid));
		
		

		return "Customer/profile";
	}

	@RequestMapping("cust/update")
	public String showUpdateForm(@RequestParam int cid, Model map) {

		Customer c = customerservice.getCustomerById(cid);
		System.out.println("inside show update form"+c);

		map.addAttribute(c);

		return "Customer/updatecust";
	}

	@RequestMapping(value = "cust/update", method = RequestMethod.POST)
	public String processUpdateForm(Customer cust, Model map) {

		// Customer c = customerservice.getCustomerByEmail(email);
		
		System.out.println("inside process update method"+cust);

		map.addAttribute(cust);
		String msg = customerservice.updateCustomer(cust);
		//Customer c = customerservice.getCustomerById(cust.getCustomerId());

		
		//hs.setAttribute("msg", msg);
		

		return "Customer/profile";
	}

}
