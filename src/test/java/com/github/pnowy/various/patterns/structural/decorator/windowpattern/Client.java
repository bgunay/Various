package com.github.pnowy.various.patterns.structural.decorator.windowpattern;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 30.05.13 14:26
 */
public class Client {
	public static void main(String[] args)
	{
		Window decoratedWindow = new VerticalScrollBarDecorator(new SimpleWindow());
		System.out.println(decoratedWindow.getDescription());
	}
}
