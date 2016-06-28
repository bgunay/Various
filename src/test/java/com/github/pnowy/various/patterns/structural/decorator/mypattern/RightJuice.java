package com.github.pnowy.various.patterns.structural.decorator.mypattern;

public class RightJuice extends RightAddition
{

	public RightJuice(Drink d)
	{
		super(d);
	}

	public double koszt()
	{
		return drink.koszt() + 1.2;
	}

	public String pobierzOpis()
	{
		return drink.pobierzOpis() + "righJuice";
	}

}
