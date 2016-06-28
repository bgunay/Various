package com.github.pnowy.various.patterns.behavioral.observer.mypattern;

/**
 * Interfejs podmiotu.
 */
public interface Observed<T>
{
	/**
	 * Metoda rejestrująca obserwatora.
	 * @param o obserwator
	 */
	public void registerObserver(Observer<T> o);

	/**
	 * Metoda usuwająca obserwatora
	 * @param o obserwator
	 */
	public void deleteObserver(Observer<T> o);

	/**
	 * Metoda powiadamiająca obserwatorów.
	 */
	public void notifyObservers();
}
