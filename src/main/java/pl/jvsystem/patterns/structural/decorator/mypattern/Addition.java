package pl.jvsystem.patterns.structural.decorator.mypattern;

public class Addition implements Drink
{
	private Drink drink;
	private double koszt;
	private String opis;

	public Addition(Drink d, double koszt, String opis)
	{
		this.drink = d;
		this.koszt = koszt;
		this.opis = opis;
	}

	@Override
	public double koszt()
	{
		return drink.koszt() + koszt;
	}

	@Override
	public String pobierzOpis()
	{
		return drink.pobierzOpis() + opis;
	}

}
