package com.github.pnowy.various.patterns.behavioral.command.designpatterns;

/**
 * RECEIVER
 */
public class DrzwiGarazowe
{
	public void doGory()
	{
		System.out.println("drzwi garazowe - do gory");
	}

	public void naDol()
	{
		System.out.println("drzwi garazowe - na dol");
	}

	public void stop()
	{
		System.out.println("drzwi garazowe - stop");
	}

	public void wlaczSwiatlo()
	{
		System.out.println("drzwi garazowe - wlacz swiatlo");
	}

	public void wylaczSwiatlo()
	{
		System.out.println("drzwi garazowe - wylacz swiatlo");
	}
}
