package com.github.pnowy.various.patterns.structural.decorator.mypattern;

public class Beer implements Drink
{

	@Override
	public double koszt()
	{
		return 4.99;
	}

	@Override
	public String pobierzOpis()
	{
		return "piwko";
	}

}
