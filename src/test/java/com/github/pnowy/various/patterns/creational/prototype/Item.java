package com.github.pnowy.various.patterns.creational.prototype;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 23.05.13 20:09
 */
public class Item
{
	private String title;
	private double price;

	@Override
	public Item clone()
	{
		Item clonedItem = null;
		try
		{
			clonedItem = (Item) super.clone();
			clonedItem.price = price;
			clonedItem.title = title;
		}
		catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		return clonedItem;
	}

	public double getPrice()
	{
		return price;
	}

	public String getTitle()
	{
		return title;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}
}
