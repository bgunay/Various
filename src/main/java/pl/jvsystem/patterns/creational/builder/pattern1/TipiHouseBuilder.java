package pl.jvsystem.patterns.creational.builder.pattern1;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 05.05.13 19:42
 */
public class TipiHouseBuilder implements HouseBuilder {

	private House house;

	public TipiHouseBuilder()
	{
		this.house = new House();
	}

	@Override
	public void buildBasement()
	{
		house.setBasement("Wooden Poles");
	}

	@Override
	public void buildStructure()
	{
		house.setStructure("Wood and ice");
	}

	@Override
	public void buildRoof()
	{
		house.setRoof("Wood, caribou and seal skins");
	}

	@Override
	public void buildInterior()
	{
		house.setInterior("Fire Wood");
	}

	@Override
	public House getHouse()
	{
		return this.house;
	}
}
