package com.github.pnowy.various.patterns.behavioral.command.designpatterns;

public class BrakPolecenia implements Polecenie
{

	public void wycofaj()
	{
		System.out.println("brak polecenia");
	}

	public void wykonaj()
	{
		System.out.println("brak polecenia");
	}

}
