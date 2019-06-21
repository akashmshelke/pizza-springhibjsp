package com.app.dao;

import java.util.List;

import com.app.pojos.Order;
import com.app.pojos.OrderDetails;

public interface Orderdao {

	/*public void open();

	public void close();
*/
	public Order placeOrder(Order order);

	public int saveOrder(Order order);
	
	public int saveOrderD(OrderDetails orderdetails);
	
	public List<OrderDetails> fetchOrderById(int id);

	public List<OrderDetails> fetchOrderByStatus(String status);
	
	public List<Order> fetchOrdersForAdmin(String status);
	
	public int dispatchOrder(int id);

}
