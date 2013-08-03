package pl.jvsystem.patterns.structural.adapter.mypattern;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 29.04.13 21:45
 */
public class DictionaryContractor implements DescriptionProvider
{
	@Override
	public String getDescription()
	{
		System.out.println("DictionaryContractor");
		return this.getClass().getName();
	}
}
