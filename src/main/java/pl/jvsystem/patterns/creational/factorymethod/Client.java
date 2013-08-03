package pl.jvsystem.patterns.creational.factorymethod;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 22.05.13 13:53
 */
public class Client
{
	public static void main(String[] args)
	{
		Creator creator = new ConcreteCreator();
		creator.anOperation();
	}
}
