package pl.jvsystem.patterns.behavioral.iterator;

public interface Iterator<T>
{
	boolean hasNext();

	T next();
}
