package pl.jvsystem.patterns.structural.flyweight;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 30.05.13 15:35
 */
public class CoffeeOrderContext
{
	private final int tableNumber;


	public CoffeeOrderContext(int tableNumber)
	{
		this.tableNumber = tableNumber;
	}

	public int getTableNumber()
	{
		return tableNumber;
	}
}
