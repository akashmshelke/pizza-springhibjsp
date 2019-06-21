package com.app.dao;

import java.util.List;

import com.app.pojos.Item;
import com.app.pojos.ItemPrice;

public interface Menudao {

	/*public void open();

	public void close();*/

	public List<String> fetchTypes();

	public List<String> fetchCategories(String type);

	public List<Item> fetchPizzas(String type, String category);

	public Item fetchPizzaById(int id);

	public ItemPrice fetchPrice(int ipid);
}
