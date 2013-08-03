package pl.jvsystem.patterns.structural.facade;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 30.05.13 15:05
 */
public class Client
{
	public static void main(String[] args)
	{
		ComputerFacade facade = new ComputerFacade();
		facade.start();
	}
}
