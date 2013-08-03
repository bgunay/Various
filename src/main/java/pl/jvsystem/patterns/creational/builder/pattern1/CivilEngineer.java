package pl.jvsystem.patterns.creational.builder.pattern1;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 05.05.13 19:44
 */
public class CivilEngineer {

	private HouseBuilder houseBuilder;

	public CivilEngineer(HouseBuilder houseBuilder)
	{
		this.houseBuilder = houseBuilder;
	}

	public House getHouse()
	{
		return this.houseBuilder.getHouse();
	}

	public void constructHouse()
	{
		this.houseBuilder.buildBasement();
		this.houseBuilder.buildStructure();
		this.houseBuilder.buildRoof();
		this.houseBuilder.buildInterior();
	}

}
