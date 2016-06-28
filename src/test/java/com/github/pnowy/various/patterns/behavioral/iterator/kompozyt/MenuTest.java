package com.github.pnowy.various.patterns.behavioral.iterator.kompozyt;

public class MenuTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MenuSkladnik ms1 = new Menu("MENU PANCAKE", "Śniadania");
		MenuSkladnik ms2 = new Menu("MENU DINER", "Obiady");
		MenuSkladnik ms3 = new Menu("MENU DESERY", "Desery");
		
		MenuSkladnik wszystkie = new Menu("ALL MENUS","cały spis");
		wszystkie.dodaj(ms1);
		wszystkie.dodaj(ms2);
//		wszystkie.dodaj(ms3);
		ms2.dodaj(new PozycjaMenu("pozycja 1", "pierwsza w diner menu", true, 1.99));
		ms2.dodaj(ms3);
		
		ms3.dodaj(new PozycjaMenu("ciacho", "super ciacho", false, 4.55));
		Kelner k = new Kelner(wszystkie);
		k.drukujMenu();
	}

}
