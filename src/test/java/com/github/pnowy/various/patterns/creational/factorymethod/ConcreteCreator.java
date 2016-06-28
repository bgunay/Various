package com.github.pnowy.various.patterns.creational.factorymethod;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 22.05.13 13:52
 */
public class ConcreteCreator extends Creator
{
	@Override
	protected Product factoryMethod()
	{
		return new ConcreteProduct();
	}
}
