package pl.jvsystem.patterns.structural.decorator.windowpattern;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 30.05.13 14:21
 */
public class WindowDecorator implements Window
{
	protected Window decoratedWindow;

	public WindowDecorator(Window decoratedWindow)
	{
		this.decoratedWindow = decoratedWindow;
	}

	@Override
	public void draw()
	{
		decoratedWindow.draw();
	}

	@Override
	public String getDescription()
	{
		return decoratedWindow.getDescription();
	}
}
