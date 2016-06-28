package com.github.pnowy.various.patterns.structural.composite;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 24.03.13 21:13
 */
public class Client
{
	public static void main(String... args)
	{
		CompositeMenuComponent mainMenu = new CompositeMenuComponent();
		CompositeMenuComponent menu = new CompositeMenuComponent("Menu główne");
		menu.add(new MenuComponent("Wydruki"));
		menu.add(new MenuComponent("Informacje"));
		CompositeMenuComponent activity = new CompositeMenuComponent("Aktywności");
		activity.add(new MenuComponent("Lista oczekujących"));
		activity.add(new MenuComponent("Moje"));
		menu.add(activity);
		CompositeMenuComponent cases = new CompositeMenuComponent("Sprawy");
		cases.add(new MenuComponent("Lista oczekujących"));
		cases.add(new MenuComponent("Moje"));
		mainMenu.add(menu);
		CompositeMenuComponent administration = new CompositeMenuComponent("Administracja");
		administration.add(new MenuComponent("Zmień hasło"));
		mainMenu.add(administration);
	}
}
