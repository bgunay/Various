package com.github.pnowy.various.patterns.behavioral.command.designpatterns;
/** CONCRETE COMMAND **/
public class PolecenieOtworzDrzwiGarazowe implements Polecenie
{
	DrzwiGarazowe garaz;

	public PolecenieOtworzDrzwiGarazowe(DrzwiGarazowe drzwi)
	{
		this.garaz = drzwi;
	}

	@Override
	public void wycofaj()
	{
		garaz.naDol();
		garaz.wylaczSwiatlo();
	}

	@Override
	public void wykonaj()
	{
		garaz.doGory();
		garaz.wlaczSwiatlo();
	}

}
