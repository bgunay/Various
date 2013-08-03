package pl.jvsystem.patterns.creational.abstractfactory;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 03.05.13 21:56
 */
public class WinGuiFactory extends AbstractGuiFactory
{
	@Override
	public Button createButton()
	{
		return new WinButton();
	}
}
