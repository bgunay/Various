package com.github.pnowy.various.patterns.structural.decorator.designpatterns;

public class Czekolada extends SkladnikDekorator
{
    Napoj napoj;

    public Czekolada(Napoj napoj)
    {
	this.napoj = napoj;
    }

    @Override
    public String pobierzOpis()
    {
	return napoj.pobierzOpis() + ", Czekolada";
    }

    @Override
    public double koszt()
    {
	return 0.20 + napoj.koszt();
    }
}
