package com.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.dao.Menudao;
import com.app.dao.Orderdao;
import com.app.pojos.Item;
import com.app.pojos.ItemPrice;
import com.app.pojos.Order;
import com.app.pojos.OrderDetails;

@Service
@Transactional
public class CartserviceImpl implements Cartservice {

	@Autowired
	private Menudao menudao;

	@Autowired
	private Orderdao orderdao;

	@Override
	public List<String> types() {

		return menudao.fetchTypes();
	}

	@Override
	public List<String> categories(String type) {

		return menudao.fetchCategories(type);
	}

	@Override
	public List<Item> pizzaByTypeAndCat(String type, String category) {

		return menudao.fetchPizzas(type, category);
	}

	@Override
	public Item fetchPizzaById(int id) {

		return menudao.fetchPizzaById(id);
	}

	@Override
	public ItemPrice fetchPrice(int iid) {

		return menudao.fetchPrice(iid);
	}

	@Override
	public List<OrderDetails> fetchOrderById(int id) {

		return orderdao.fetchOrderById(id);

	}

	@Override
	public List<OrderDetails> fetchOrderByStatus(String status) {

		return orderdao.fetchOrderByStatus(status);
	}

	@Override
	public Order placeOrder(Order order) {

		return orderdao.placeOrder(order);

	}

	@Override
	public int saveOrder(Order order) {

		return orderdao.saveOrder(order);
	}

	@Override
	public int saveOrderD(OrderDetails orderdetails) {

		return orderdao.saveOrderD(orderdetails);
	}

	@Override
	public List<Order> fetchOrdersForAdmin(String status) {

		return orderdao.fetchOrdersForAdmin(status);
	}

	@Override
	public int dispatchOrder(int id) {

		return orderdao.dispatchOrder(id);
	}
}