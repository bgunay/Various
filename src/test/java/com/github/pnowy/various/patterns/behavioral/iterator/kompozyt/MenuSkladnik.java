package com.github.pnowy.various.patterns.behavioral.iterator.kompozyt;

import java.util.Iterator;

public abstract class MenuSkladnik
{
	//metody kompozytowe - dodające i usuwające składniki
	public void dodaj(MenuSkladnik ms)
	{
		throw new UnsupportedOperationException();
	}

	public void usun(MenuSkladnik ms)
	{
		throw new UnsupportedOperationException();
	}

	public MenuSkladnik pobierzPotomek(int i)
	{
		throw new UnsupportedOperationException();
	}

	// metody operacyjne wykorzystywane przez pozycje menu
	public String poberzNazwa()
	{
		throw new UnsupportedOperationException();
	}

	public String pobierzOpis()
	{
		throw new UnsupportedOperationException();
	}

	public double pobierzCena()
	{
		throw new UnsupportedOperationException();
	}

	public boolean isWegetarianska()
	{
		throw new UnsupportedOperationException();
	}

	public void drukuj()
	{
		throw new UnsupportedOperationException();
	}

	// iterator
	public Iterator<MenuSkladnik> utworzIterator()
	{
		return new IteratorPusty();
	}
}
