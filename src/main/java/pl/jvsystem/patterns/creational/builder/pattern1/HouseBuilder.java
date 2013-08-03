package pl.jvsystem.patterns.creational.builder.pattern1;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 05.05.13 19:37
 */
public interface HouseBuilder
{
	public void buildBasement();

	public void buildStructure();

	public void buildRoof();

	public void buildInterior();

	public House getHouse();
}
