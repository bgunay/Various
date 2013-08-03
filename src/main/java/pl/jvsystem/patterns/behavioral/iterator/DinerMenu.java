package pl.jvsystem.patterns.behavioral.iterator;

public class DinerMenu implements Menu
{
	private static final int MAX_LICZBA_ELEM = 6;
	int liczbaElementow = 0;
	PozycjaMenu[] pozycje;

	public DinerMenu()
	{
		pozycje = new PozycjaMenu[MAX_LICZBA_ELEM];

	}

	public void dodajElement(String n, String o, boolean w, double c)
	{
		PozycjaMenu pm = new PozycjaMenu(n, o, w, c);
		if (liczbaElementow >= MAX_LICZBA_ELEM)
		{
			System.err.println("Menu jest pełne");
		}
		else
		{
			pozycje[liczbaElementow] = pm;
			liczbaElementow++;
		}
	}

	public java.util.Iterator<PozycjaMenu> utworzIterator()
	{
		return new DinerMenuIterator(pozycje);
	}

}
