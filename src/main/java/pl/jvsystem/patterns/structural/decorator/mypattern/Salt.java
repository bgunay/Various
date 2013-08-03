package pl.jvsystem.patterns.structural.decorator.mypattern;

public class Salt extends Addition
{
	public Salt(Drink d, double koszt, String opis)
	{
		super(d, koszt, opis);
	}
}
