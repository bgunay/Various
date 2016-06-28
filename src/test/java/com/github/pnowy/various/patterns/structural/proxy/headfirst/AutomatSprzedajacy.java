package com.github.pnowy.various.patterns.structural.proxy.headfirst;

public class AutomatSprzedajacy {
	Stan stanBrakGum;
	Stan stanNieMaMonety;
	Stan stanJestMoneta;
	Stan stanGumaSprzedana;
	Stan stanWygrana;
	
	Stan stan = stanBrakGum;
	int liczba=0;
	String lokalizacja;
	
	public AutomatSprzedajacy(String l, int liczbaGum) {
		stanNieMaMonety = new StanNieMaMonety(this);
		stanBrakGum = new StanBrakGum(this);
		stanGumaSprzedana = new StanGumaSprzedana(this);
		stanJestMoneta = new StanJestMoneta(this);
		stanWygrana = new StanWygrana(this);
		
		this.lokalizacja = l;
		this.liczba=liczbaGum;
		if (liczbaGum>0)
			stan = stanNieMaMonety;
	}
	
	public void wlozMonete() {
		stan.wlozMonete();
	}
	
	public void zwrocMonete() {
		stan.zwrocMonete();
	}
	
	public void przekrecGalke() {
		stan.przekrecGalke();
		stan.wydaj();
	}
	
	public void zwolnijGume() {
		System.out.println("wypada guma");
		if (liczba != 0)
			liczba--;
	}
	
	public void ustawStan(Stan s) {
		this.stan = s;
	}
	
	public Stan pobierzStanJestMoneta() {
		return stanJestMoneta;
	}
	
	public Stan pobierzStanNieMaMonety() {
		return stanNieMaMonety;
	}
	
	public Stan pobierzStanGumaSprzedana() {
		return stanGumaSprzedana;
	}
	
	public Stan pobierzStanBrakGum() {
		return stanBrakGum;
	}
	
	public Stan pobierzStanWygrana() {
		return stanWygrana;
	}
	
	public String pobierzLokalizacja() {
		return lokalizacja;
	}

	@Override
	public String toString() {
		return "AutomatSprzedajacy [liczba=" + liczba + ", stan=" + stan + "]";
	}
	
	
}
