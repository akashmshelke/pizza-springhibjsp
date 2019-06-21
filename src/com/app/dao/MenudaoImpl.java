package com.app.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.app.pojos.Item;
import com.app.pojos.ItemPrice;

@Repository
public class MenudaoImpl implements Menudao {

	@Autowired
	private SessionFactory sf;

	@SuppressWarnings("unchecked")
	@Override
	public List<String> fetchTypes() {

		String query = "select distinct item.type from Item item";
		List<String> types;
		types = sf.getCurrentSession().createQuery(query).list();
		return types;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> fetchCategories(String type) {
		
		String query = "select distinct item.category from Item item where item.type=:Type";
		return sf.getCurrentSession().createQuery(query).setParameter("Type", type).list();

	}

	@Override
	public List<Item> fetchPizzas(String type, String category) {
		
		String query = "select item from Item item where item.type=:Type and item.category=:Category";
		@SuppressWarnings("unchecked")
		List<Item> pizzaList = (List<Item>) sf.getCurrentSession().createQuery(query).setParameter("Type", type)
				.setParameter("Category", category).list();
		return pizzaList;

	}

	@Override
	public Item fetchPizzaById(int id) {

		Item item;
		String query = "select item from Item item where item.ItemId=:Id";
		item = (Item) sf.getCurrentSession().createQuery(query).setParameter("Id", id).uniqueResult();
		return item;
	}
	
	@Override
	public ItemPrice fetchPrice(int ipid) {

		String query = "select itemprice from ItemPrice itemprice where itemprice.pricingId=:ipId";
		ItemPrice itemprice = (ItemPrice) sf.getCurrentSession().createQuery(query).setParameter("ipId", ipid)
				.uniqueResult();

		return itemprice;
	}
}