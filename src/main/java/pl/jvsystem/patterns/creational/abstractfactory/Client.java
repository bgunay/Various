package pl.jvsystem.patterns.creational.abstractfactory;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 03.05.13 22:11
 */
public class Client
{

	public static void main(String[] args)
	{
		// constructor parameter could depends on runtime, etc.
		new Application(new OSXGuiFactory());
	}

	public static class Application
	{
		public Application(AbstractGuiFactory guiFactory)
		{

			guiFactory.createButton().paint();
		}
	}

}
