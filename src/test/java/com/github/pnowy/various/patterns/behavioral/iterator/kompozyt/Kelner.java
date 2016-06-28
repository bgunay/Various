package com.github.pnowy.various.patterns.behavioral.iterator.kompozyt;

public class Kelner {
	MenuSkladnik wszystkieMenu;
	
	public Kelner(MenuSkladnik wm) {
		this.wszystkieMenu=wm;
	}
	
	public void drukujMenu() {
		wszystkieMenu.drukuj();
	}
		
}
