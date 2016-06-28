package com.github.pnowy.various.patterns.behavioral.observer.mypattern;

/**
 * Interfejs obserwatora.
 */
public interface Observer<T>
{
	public void update(T o);
}
