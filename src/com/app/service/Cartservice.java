package com.app.service;

import java.util.List;

import com.app.pojos.Item;
import com.app.pojos.ItemPrice;
import com.app.pojos.Order;
import com.app.pojos.OrderDetails;

public interface Cartservice {

	public List<String> types();

	public List<String> categories(String type);

	public List<Item> pizzaByTypeAndCat(String type, String category);

	public Item fetchPizzaById(int id);

	public ItemPrice fetchPrice(int iid);

	public List<OrderDetails> fetchOrderById(int id);

	public List<OrderDetails> fetchOrderByStatus(String status);

	public Order placeOrder(Order order);
	
	public int saveOrder(Order order);
	
	public int saveOrderD(OrderDetails orderdetails);
	
	public List<Order> fetchOrdersForAdmin(String status);
	
	public int dispatchOrder(int id);

}
