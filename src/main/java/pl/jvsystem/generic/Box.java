package pl.jvsystem.generic;

/**
 * @author przemek nowak <przemek.nowak.pl@gmail.com>
 */
public class Box<E>
{

	private E element;

	public Box(E element)
	{
		this.element = element;
	}

	public E getElement()
	{
		return element;
	}
}
