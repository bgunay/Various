package com.github.pnowy.various.patterns.behavioral.iterator.kompozyt;

public class PozycjaMenu extends MenuSkladnik {
	String nazwa;
	String opis;
	boolean wegetarianska;
	double cena;
	
	public PozycjaMenu(String n, String o, boolean w, double c) {
		this.nazwa=n;
		this.opis=o;
		this.wegetarianska=w;
		this.cena=c;
	}
	
	public String poberzNazwa() {
		return nazwa;
	}
	public String pobierzOpis() {
		return opis;
	}
	public double pobierzCena() {
		return cena;
	}
	public boolean isWegetarianska() {
		return wegetarianska;
	}
	
	public void drukuj() {
		System.out.println("PozycjaMenu [cena=" + cena + ", nazwa=" + nazwa + ", opis="
		+ opis + ", wegetarianska=" + wegetarianska + "]");
	}

}
