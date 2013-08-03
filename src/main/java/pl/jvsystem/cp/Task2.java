package pl.jvsystem.cp;

import pl.jvsystem.cp.menu.CompositeMenuComponent;
import pl.jvsystem.cp.menu.MenuComponent;
import pl.jvsystem.cp.menu.MenuVisitor;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 06.04.13 12:20
 */
public class Task2
{
	public static void main(String... args)
	{
		CompositeMenuComponent menu = new CompositeMenuComponent("Menu główne");
		menu.add(new MenuComponent("Wydruki"));
		menu.add(new MenuComponent("Informacje"));
		CompositeMenuComponent administration = new CompositeMenuComponent("Administracja");
		administration.add(new MenuComponent("Zmień hasło"));
		menu.add(administration);
		CompositeMenuComponent activity = new CompositeMenuComponent("Aktywności");
		activity.add(new MenuComponent("Lista oczekujących"));
		activity.add(new MenuComponent("Moje"));
		menu.add(activity);
		CompositeMenuComponent cases = new CompositeMenuComponent("Sprawy");
		cases.add(new MenuComponent("Lista oczekujących"));
		cases.add(new MenuComponent("Moje"));
		menu.add(cases);

		menu.accept(new MenuVisitor());
	}
}
