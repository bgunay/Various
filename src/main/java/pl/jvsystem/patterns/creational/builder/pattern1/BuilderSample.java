package pl.jvsystem.patterns.creational.builder.pattern1;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 05.05.13 19:48
 */
public class BuilderSample
{
	public static void main(String[] args)
	{
		HouseBuilder iglooBuilder = new IglooHouseBuilder();
		CivilEngineer civilEngineer = new CivilEngineer(iglooBuilder);
		civilEngineer.constructHouse();
		House house = civilEngineer.getHouse();

		System.out.println("Constructed house: "+house);
	}
}
