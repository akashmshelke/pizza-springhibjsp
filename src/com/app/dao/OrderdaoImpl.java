package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Order;
import com.app.pojos.OrderDetails;

@Repository
public class OrderdaoImpl implements Orderdao{

	@Autowired
	private SessionFactory sf;
	
	/*private Session session;
	@Override
	public void open() {
		session = HbUtil.getSessionFactory().openSession();
	}
	@Override
	public void close() {
		session.close();
	}*/
	
	@Override
	public Order placeOrder(Order order) {

		//session.save(order);
		sf.getCurrentSession().save(order);
		return order;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetails> fetchOrderById(int id) {

		System.out.println("*********** In Dao *********"+id);
		String query = "select orderdetails from OrderDetails orderdetails where OrderId=:ID";
		//OrderDetails orderd = (OrderDetails) session.createQuery(query).setParameter("ID", id).uniqueResult();
		//List<OrderDetails> orderd = (List<OrderDetails>) sf.getCurrentSession().createQuery(query).setParameter("ID", id).list();
		
		return sf.getCurrentSession().createQuery(query).setParameter("ID", id).list();

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetails> fetchOrderByStatus(String status) {

		String query = "select orderdetails from OrderDetails orderdetails where order.status=:Status order by order.orderTime desc";
		/*List<OrderDetails> orderListByStatus = (List<OrderDetails>) session.createQuery(query)
				.setParameter("Status", status).list();*/

		//List<OrderDetails> orderListByStatus = sf.getCurrentSession().createQuery(query)
			//	.setParameter("Status", status).list();
		
		return sf.getCurrentSession().createQuery(query).setParameter("Status", status).list();

	}
	@Override
	public int saveOrder(Order order) {
		
		int id = (int) sf.getCurrentSession().save(order);
		
		return id;
	}
	@Override
	public int saveOrderD(OrderDetails orderdetails) {
		
		int i = (int) sf.getCurrentSession().save(orderdetails);
		
		return i;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> fetchOrdersForAdmin(String status) {

		List<Order> orders = null;
		System.out.println("In Dao");
		if(status == null){
			System.out.println("In Null status");
			String query = "select order from Order order";
			orders = (List<Order>) sf.getCurrentSession().createQuery(query).list();
		}else{
		String query = "select order from Order order where order.status=:Status";
		orders = (List<Order>) sf.getCurrentSession().createQuery(query).setParameter("Status", status).list();
		}
		return orders;
	}
	@Override
	public int dispatchOrder(int id) {
		
		String query = "update Order set status='Dispatched' where orderId=:Id";
		System.out.println("***" +id);
		System.out.println("### In Dispatch Dao");
		
		return sf.getCurrentSession().createQuery(query).setParameter("Id", id).executeUpdate();
	}
}
