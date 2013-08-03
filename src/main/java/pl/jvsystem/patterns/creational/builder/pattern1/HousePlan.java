package pl.jvsystem.patterns.creational.builder.pattern1;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 04.05.13 11:21
 */
public interface HousePlan
{
	public void setBasement(String basement);

	public void setStructure(String structure);

	public void setRoof(String roof);

	public void setInterior(String interior);
}
