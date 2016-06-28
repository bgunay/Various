package com.github.pnowy.various.patterns.structural.decorator.designpatterns;

public abstract class Napoj
{
    String opis = "Nieznany napój";

    public String pobierzOpis()
    {
	return opis;
    }

    public abstract double koszt();
}
