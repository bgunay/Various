package pl.jvsystem.patterns.behavioral.strategy.mypatter;

public class Main
{

	public static void main(String[] args)
	{
		Character ch = new King();
		ch.fight();
		ch.setWeapon(new Knife());
		ch.fight();
	}

}