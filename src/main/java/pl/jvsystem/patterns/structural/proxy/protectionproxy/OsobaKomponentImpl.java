package pl.jvsystem.patterns.structural.proxy.protectionproxy;

public class OsobaKomponentImpl implements OsobaKomponent
{
	String nazwa;
	String plec;
	String zainteresowania;
	int ranking;
	int rankingLiczba = 0;

	@Override
	public String pobierzImie()
	{
		return nazwa;
	}

	@Override
	public String pobierzPlec()
	{
		return plec;
	}

	@Override
	public int pobierzRankingUrody()
	{
		if (rankingLiczba == 0)
		{
			return 0;
		}
		return (ranking / rankingLiczba);
	}

	@Override
	public String pobierzZainteresowania()
	{
		return zainteresowania;
	}

	@Override
	public void ustawImie(String nazwa)
	{
		this.nazwa = nazwa;
	}

	@Override
	public void ustawPlec(String plec)
	{
		this.plec = plec;
	}

	@Override
	public void ustawRankingUrody(int ranking)
	{
		this.ranking += ranking;
		rankingLiczba++;
	}

	@Override
	public void ustawZainteresowania(String zainteresowania)
	{
		this.zainteresowania = zainteresowania;
	}

}
