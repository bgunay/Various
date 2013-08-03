package pl.jvsystem.patterns.creational.builder.pattern1;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 05.05.13 19:39
 */
public class IglooHouseBuilder implements HouseBuilder
{
	private House house;

	public IglooHouseBuilder()
	{
		this.house = new House();
	}

	@Override
	public void buildBasement()
	{
		house.setBasement("Ice Bars");
	}

	@Override
	public void buildStructure()
	{
		house.setStructure("Ice Blocks");
	}

	@Override
	public void buildRoof()
	{
		house.setRoof("Ice Dome");
	}

	@Override
	public void buildInterior()
	{
		house.setInterior("Ice Carvings");
	}

	@Override
	public House getHouse()
	{
		return this.house;
	}
}
