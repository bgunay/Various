package com.github.pnowy.various.patterns.structural.adapter.designpatterns;

public class IndykAdapter implements Kaczka
{
	private Indyk indyk;

	public IndykAdapter(Indyk i)
	{
		this.indyk = i;
	}

	public void kwacz()
	{
		indyk.gulgocz();
	}

	public void lataj()
	{
		for (int i = 0; i < 5; i++)
		{
			indyk.lataj();
		}
	}

}
