package com.github.pnowy.various.patterns.behavioral.iterator;

import java.util.ArrayList;


public class Kelnerka
{
	ArrayList<Menu> menu;

	public Kelnerka(ArrayList<Menu> menu)
	{
		this.menu = menu;
	}

	public void drukujMenu()
	{
		java.util.Iterator<Menu> i = menu.iterator();
		while (i.hasNext())
		{
			drukujMenu((Iterator<PozycjaMenu>) i.next().utworzIterator());
		}
	}

	void drukujMenu(Iterator<PozycjaMenu> iterator)
	{
		while (iterator.hasNext())
		{
			PozycjaMenu pm = iterator.next();
			System.out.println(pm);
		}
	}

}
