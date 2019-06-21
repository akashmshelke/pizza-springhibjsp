package com.app.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.app.pojos.OrderDetails;
import com.app.service.Cartservice;

@Controller
@RequestMapping("/")
public class OrderController {

	@Autowired
	private Cartservice cartservice;

	@SuppressWarnings({ "unused", "unchecked" })
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String Menu(@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "cat", required = false) String cat, ModelMap map, HttpSession hs) {

		map.addAttribute("typeList", cartservice.types());

		map.addAttribute("catList", cartservice.categories(type));

		map.addAttribute("pizza", cartservice.pizzaByTypeAndCat(type, cat));

		List<Integer> cart = (List<Integer>) hs.getAttribute("cart");

		return "index";
	}

	@RequestMapping(value = "/pizza", method = RequestMethod.GET)
	public String getPizzaById(@RequestParam(value = "id") int id, ModelMap map) {

		map.addAttribute("item", cartservice.fetchPizzaById(id));

		return "Cart/selectsize";
	}

	@RequestMapping(value = "/price", method = RequestMethod.GET)
	public String getPizzaPrice(int id) {

		cartservice.fetchPrice(id);
		return "main";
	}

	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public String getOrders(@RequestParam(value = "status", required = false) String status, ModelMap map,
			HttpSession hs) {

		map.addAttribute("order", cartservice.fetchOrdersForAdmin(status));

		return "admin/main";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateOrderStatus(@RequestParam(value = "id", required = false) int id, ModelMap map) {

		cartservice.dispatchOrder(id);
		map.addAttribute("id", id);
		return "admin/dispatch";
	}

	@RequestMapping(value = "/orderdetails", method = RequestMethod.GET)
	public String orderDetails(@RequestParam(value = "oid") int oid, ModelMap map) {

		// System.out.println(oid);

		List<OrderDetails> odlist = (List<OrderDetails>) cartservice.fetchOrderById(oid);
		// System.out.println(odlist);
		map.addAttribute("orderdetails", odlist);
		return "Cart/orderdetails";
	}

}
