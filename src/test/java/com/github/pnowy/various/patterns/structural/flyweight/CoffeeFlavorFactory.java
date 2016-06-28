package com.github.pnowy.various.patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 30.05.13 15:38
 */
public class CoffeeFlavorFactory
{
	private Map<String, CoffeeFlavor> flavors = new HashMap<String, CoffeeFlavor>();

	public CoffeeFlavor getCoffeeFlavor(String flavorName)
	{
		CoffeeFlavor flavor = flavors.get(flavorName);
		if (flavor == null)
		{
			flavor = new CoffeeFlavor(flavorName);
			flavors.put(flavorName, flavor);
		}
		return flavor;
	}

	public int getTotalCoffeeFlavorsMade()
	{
		return flavors.size();
	}

}
