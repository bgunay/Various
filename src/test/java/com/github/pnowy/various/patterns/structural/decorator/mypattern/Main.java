package com.github.pnowy.various.patterns.structural.decorator.mypattern;

public class Main
{

    public static void main(String[] args)
    {
	Drink w = new Whiskey();
	// w = new RightJuice(w);
	w = new Addition(w, 3, "pieprz");
	System.out.println(w.pobierzOpis() + w.koszt());
    }

}
