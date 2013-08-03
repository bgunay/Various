package pl.jvsystem.patterns.behavioral.strategy.mypatter;

public abstract class Character
{
	protected Weapon weapon;

	public void fight()
	{
		weapon.useWeapon();
	}

	public void setWeapon(Weapon w)
	{
		this.weapon = w;
	}
}
