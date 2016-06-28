package com.github.pnowy.various.patterns.behavioral.templateMethod.sortowanie;

public class Kaczka implements Comparable<Kaczka>
{
    String nazwa;
    int waga;

    public Kaczka(String nazwa, int waga)
    {
	this.nazwa = nazwa;
	this.waga = waga;
    }

    @Override
    public String toString()
    {
	return "Kaczka [nazwa=" + nazwa + ", waga=" + waga + "]";
    }

    public int compareTo(Kaczka o)
    {
	if (this.waga < o.waga)
	    return -1;
	else if (this.waga == o.waga)
	    return 0;
	else
	    return 1;
    }

}
