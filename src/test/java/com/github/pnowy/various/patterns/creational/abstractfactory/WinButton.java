package com.github.pnowy.various.patterns.creational.abstractfactory;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 03.05.13 21:52
 */
public class WinButton implements Button
{
	@Override
	public void paint()
	{
		System.out.println("WinButton");
	}
}
