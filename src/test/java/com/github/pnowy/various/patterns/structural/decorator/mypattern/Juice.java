package com.github.pnowy.various.patterns.structural.decorator.mypattern;

public class Juice implements Drink
{
    private Drink drink;

    public Juice(Drink d)
    {
	this.drink = d;
    }

    public double koszt()
    {
	return 0.50 + drink.koszt();
    }

    public String pobierzOpis()
    {
	return "sok, " + drink.pobierzOpis();
    }

}
