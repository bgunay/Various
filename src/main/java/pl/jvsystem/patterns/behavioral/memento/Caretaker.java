package pl.jvsystem.patterns.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 02.06.13 12:54
 */
class Caretaker
{
	public static void main(String[] args)
	{
		List<Originator.Memento> savedStates = new ArrayList<Originator.Memento>();

		Originator originator = new Originator();
		originator.set("State1");
		originator.set("State2");
		savedStates.add(originator.saveToMemento());
		originator.set("State3");
		// We can request multiple mementos, and choose which one to roll back to.
		savedStates.add(originator.saveToMemento());
		originator.set("State4");

		originator.restoreFromMemento(savedStates.get(1));
	}
}
