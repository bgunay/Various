package com.github.pnowy.various.patterns.structural.flyweight;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 30.05.13 15:47
 */
public class Client {
	// the flavors ordered
	private static CoffeeFlavor[] flavors = new CoffeeFlavor[100];
	// the tables for the orders
	private static CoffeeOrderContext[] tables = new CoffeeOrderContext[100];
	private static int ordersMade = 0;
	private static CoffeeFlavorFactory flavorFactory;

	public static void takeOrders(String flavorIn, int table)
	{
		flavors[ordersMade] = flavorFactory.getCoffeeFlavor(flavorIn);
		tables[ordersMade++] = new CoffeeOrderContext(table);
	}

	public static void main(String[] args)
	{
		flavorFactory = new CoffeeFlavorFactory();
		takeOrders("Cappucino", 2);
		takeOrders("Cappucino", 2);
		takeOrders("Frappe", 1);
		takeOrders("Frappe", 1);
		takeOrders("Espresso", 1);
		takeOrders("Frappe", 897);
		takeOrders("Cappuccino", 97);
		takeOrders("Cappuccino", 97);
		takeOrders("Frappe", 3);
		takeOrders("Espresso", 3);
		takeOrders("Cappuccino", 3);
		takeOrders("Espresso", 96);
		takeOrders("Frappe", 552);
		takeOrders("Cappuccino", 121);
		takeOrders("Espresso", 121);

		for (int i = 0; i < ordersMade; i++)
		{
			flavors[i].serverCoffee(tables[i]);
		}

		System.out.println("totals CoffeFlavor objects made: "+flavorFactory.getTotalCoffeeFlavorsMade());

	}

}
