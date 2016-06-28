package com.github.pnowy.various.patterns.structural.proxy.headfirst;

import java.util.Random;


public class StanJestMoneta implements Stan {
	Random losowaWygrana = new Random(System.currentTimeMillis());
	AutomatSprzedajacy automat;
	
	public StanJestMoneta(AutomatSprzedajacy a) {
		this.automat=a;
	}
	
	@Override
	public void przekrecGalke() {
		System.out.println("przekręciłeś gałkę");
		int wygrana = losowaWygrana.nextInt(10);
		if (wygrana==0)
			automat.ustawStan(automat.pobierzStanWygrana());
		else
			automat.ustawStan(automat.pobierzStanGumaSprzedana());
	}

	@Override
	public void wlozMonete() {
		System.out.println("nie możesz włożyć więcej niż jednej monety");
	}

	@Override
	public void wydaj() {
		System.out.println("nie wydano gumy");
	}

	@Override
	public void zwrocMonete() {
		System.out.println("moneta zwrócona");
		automat.ustawStan(automat.pobierzStanNieMaMonety());
	}

}
