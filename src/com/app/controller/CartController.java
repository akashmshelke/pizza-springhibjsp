package com.app.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Customer;
import com.app.pojos.ItemPrice;
import com.app.pojos.Order;
import com.app.pojos.OrderDetails;
import com.app.service.Cartservice;

@Controller
@RequestMapping("/")
public class CartController {

	@Autowired
	private Cartservice cartservice;

	List<Integer> cartids = new ArrayList<>();

	@RequestMapping(value = "/addtocart")
	public String addtocart(@RequestParam(value = "priceid", required = false) String[] priceids, ModelMap map,
			HttpSession hs) {

		for (String pid : priceids) {
			cartids.add(Integer.parseInt(pid));
		}
		hs.setAttribute("cart", cartids);

		return "redirect:/menu";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/placeorder")
	public String placeOrder(HttpSession hs, Model map) {

		Customer customer = (Customer) hs.getAttribute("customer");
		List<Integer> cart = (List<Integer>) hs.getAttribute("cart");

		Date dNow = new Date();
		Order order = new Order();

		List<OrderDetails> odList = new ArrayList<OrderDetails>();

		for (int priceid : cart) {

			OrderDetails orderdetails = new OrderDetails();
			ItemPrice itemprice = new ItemPrice();

			itemprice.setPricingId(priceid);
			orderdetails.setOrder(order);

			orderdetails.setItemprice(itemprice);
			odList.add(orderdetails);

		}
		order.setOrderDetailsList(odList);
		order.setOrderTime(dNow);
		order.setStatus("Pending");
		order.setCustomer(customer);

		cartservice.placeOrder(order);

		map.addAttribute("address", customer.getAddress());
		cart.clear();
		return "success";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/showcart", method = RequestMethod.GET)
	public String showCart(ModelMap map, HttpSession hs) {

		List<Integer> cart = (List<Integer>) hs.getAttribute("cart");

		if (cart == null) {

			map.addAttribute("cartmsg", " * Cart is empty");

		} else {
			ItemPrice ip = null;
			List<ItemPrice> pricelist = new ArrayList<ItemPrice>();

			double total = 0.0;
			for (Integer priceid : cart) {
				ip = cartservice.fetchPrice(priceid);
				total = total + ip.getPrice();
				pricelist.add(ip);
			}
			map.addAttribute("pricelist", pricelist);
			map.addAttribute("total", total);

		}

		return "Cart/showcart";
	}

}
