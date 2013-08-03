package pl.jvsystem.patterns.structural.flyweight;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 30.05.13 15:37
 */
public class CoffeeFlavor implements CoffeeOrder
{

	private final String flavor;

	public CoffeeFlavor(String flavor)
	{
		this.flavor = flavor;
	}

	public String getFlavor()
	{
		return flavor;
	}

	@Override
	public void serverCoffee(CoffeeOrderContext context)
	{
		System.out.println("Serving Coffee flavor: " + flavor + " to table number: " + context.getTableNumber());
	}
}
