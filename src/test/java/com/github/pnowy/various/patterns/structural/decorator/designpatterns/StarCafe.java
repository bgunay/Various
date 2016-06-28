package com.github.pnowy.various.patterns.structural.decorator.designpatterns;

import static java.lang.System.out;

public class StarCafe
{
    public static void main(String... strings)
    {
	Napoj napoj = new Espresso();
	napoj = new Czekolada(napoj);
	napoj = new Czekolada(napoj);
	out.println(napoj.pobierzOpis() + " " + napoj.koszt());
    }
}
