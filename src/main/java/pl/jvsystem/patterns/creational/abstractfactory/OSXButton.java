package pl.jvsystem.patterns.creational.abstractfactory;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 03.05.13 21:54
 */
public class OSXButton implements Button
{
	@Override
	public void paint()
	{
		System.out.println("OSX Button");
	}
}
