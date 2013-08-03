package pl.jvsystem.patterns.structural.adapter.mypattern;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 29.04.13 21:49
 */
public class ExtendImmutableContractorAdapter implements DescriptionProvider
{
	private  ExtendImmutableContractor contractor;

	public ExtendImmutableContractorAdapter(ExtendImmutableContractor contractor)
	{
		this.contractor = contractor;
	}

	@Override
	public String getDescription()
	{
		return contractor.getDesc();
	}
}
