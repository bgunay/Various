package com.github.pnowy.various.patterns.behavioral.iterator.kompozyt;

import java.util.ArrayList;
import java.util.Iterator;

public class Menu extends MenuSkladnik
{
	ArrayList<MenuSkladnik> menuSkladnik = new ArrayList<MenuSkladnik>();
	String nazwa;
	String opis;

	public Menu(String n, String o)
	{
		this.nazwa = n;
		this.opis = o;
	}

	public void dodaj(MenuSkladnik ms)
	{
		menuSkladnik.add(ms);
	}

	public void usun(MenuSkladnik ms)
	{
		menuSkladnik.remove(ms);
	}

	public MenuSkladnik pobierzPotomek(int i)
	{
		return menuSkladnik.get(i);
	}

	// metody operacyjne wykorzystywane przez pozycje menu
	public String poberzNazwa()
	{
		return nazwa;
	}

	public String pobierzOpis()
	{
		return opis;
	}

	public void drukuj()
	{
		System.out.println("Menu [nazwa=" + nazwa + ", opis=" + opis + "]");

		Iterator<MenuSkladnik> i = menuSkladnik.iterator();
		while (i.hasNext())
		{
			// jeżeli w drzewie są inne składniki to rekurencyjnie wywołujemy met. drukuj
			i.next().drukuj();
		}
	}

	public Iterator<MenuSkladnik> utworzIterator()
	{
		return new IteratorKompozytu(menuSkladnik.iterator());
	}


}
