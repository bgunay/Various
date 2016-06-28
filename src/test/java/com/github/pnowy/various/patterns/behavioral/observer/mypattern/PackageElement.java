package com.github.pnowy.various.patterns.behavioral.observer.mypattern;

/**
 * Klasa implementująca element paczki.
 * Implementuje interfejsy obserwatora (parametryzowanego typem)
 */
public class PackageElement implements Observer<UpdateBean>, ShowElement
{

	public void show()
	{
		System.out.println("wypisuje aktualny status elementu dla packageElement="+this);
	}

	@Override
	public void update(UpdateBean o)
	{
		show();
	}
}
