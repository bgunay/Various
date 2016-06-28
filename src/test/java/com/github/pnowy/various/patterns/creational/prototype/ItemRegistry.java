package com.github.pnowy.various.patterns.creational.prototype;

import java.util.HashMap;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 23.05.13 20:20
 */
public class ItemRegistry
{
	private HashMap<String, Item> map = new HashMap<String, Item>();

	public ItemRegistry()
	{
		loadCache();
	}

	public Item createBasicItem(String type)
	{
		return map.get(type).clone();
	}

	private void loadCache()
	{
		Book book = new Book();
		book.setTitle("Design Patterns");
		book.setPrice(20.0);
		map.put("book", book);
		CD cd = new CD();
		cd.setTitle("various");
		cd.setPrice(10.0);
		map.put("cd", cd);
	}

}
