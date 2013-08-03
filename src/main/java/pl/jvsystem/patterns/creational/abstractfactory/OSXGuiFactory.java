package pl.jvsystem.patterns.creational.abstractfactory;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 03.05.13 22:10
 */
public class OSXGuiFactory extends AbstractGuiFactory
{
	@Override
	public Button createButton()
	{
		return new OSXButton();
	}
}
