package pl.jvsystem.patterns.creational.factorymethod;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 21.05.13 22:53
 */
public abstract class Creator
{

	public void anOperation()
	{
		Product product = factoryMethod();
	}

	protected abstract Product factoryMethod();

}
