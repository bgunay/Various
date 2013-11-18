package pl.jvsystem.patterns.behavioral.nullobject;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 18.11.13 19:58
 */
public class Product extends ProductBase
{
	@Override
	public void rateIt(int value)
	{
		System.out.println("Rate product: " + value);
	}
}
