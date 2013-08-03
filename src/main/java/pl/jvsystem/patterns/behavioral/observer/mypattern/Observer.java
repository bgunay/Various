package pl.jvsystem.patterns.behavioral.observer.mypattern;

/**
 * Interfejs obserwatora.
 */
public interface Observer<T>
{
	public void update(T o);
}
