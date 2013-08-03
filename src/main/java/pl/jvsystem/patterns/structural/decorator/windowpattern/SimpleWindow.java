package pl.jvsystem.patterns.structural.decorator.windowpattern;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 30.05.13 13:45
 */
public class SimpleWindow implements Window
{
	@Override
	public void draw()
	{
		System.out.println("drawing window...");
	}

	@Override
	public String getDescription()
	{
		return "SimpleWindow";
	}
}
