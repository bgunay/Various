package com.github.pnowy.various.patterns.structural.decorator.windowpattern;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 30.05.13 14:24
 */
public class VerticalScrollBarDecorator extends WindowDecorator
{
	public VerticalScrollBarDecorator(Window decoratedWindow)
	{
		super(decoratedWindow);
	}

	@Override
	public void draw()
	{
		super.draw();
		drawVerticalScrollBar();
	}

	private void drawVerticalScrollBar()
	{
		System.out.println("drawing vertical scroll bar...");
	}

	@Override
	public String getDescription()
	{
		return super.getDescription() + ", including vertical scroll bar";
	}
}
