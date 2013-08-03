package pl.jvsystem.patterns.structural.decorator.mypattern;

public abstract class RightAddition implements Drink
{
	protected Drink drink;

	public RightAddition(Drink d)
	{
		this.drink = d;
	}
}
