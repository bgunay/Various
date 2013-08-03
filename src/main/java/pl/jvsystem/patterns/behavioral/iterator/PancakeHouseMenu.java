package pl.jvsystem.patterns.behavioral.iterator;

import pl.jvsystem.patterns.behavioral.iterator.Menu;
import pl.jvsystem.patterns.behavioral.iterator.PozycjaMenu;

import java.util.ArrayList;
import java.util.Iterator;


public class PancakeHouseMenu implements Menu
{
	ArrayList<PozycjaMenu> pozycje;

	public Iterator<PozycjaMenu> utworzIterator()
	{
		return pozycje.iterator();
	}

	public PancakeHouseMenu()
	{
		pozycje = new ArrayList<PozycjaMenu>();
		pozycje.add(new PozycjaMenu("Sniadanie", "super śniadanko", false, 12.99));
		pozycje.add(new PozycjaMenu("obiad", "super obiad", true, 22.99));
		pozycje.add(new PozycjaMenu("kolacja", "super kolacja", true, 15.99));
		pozycje.add(new PozycjaMenu("lunch", "super lunch", false, 6.69));
	}
}
