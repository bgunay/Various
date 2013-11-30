package pl.jvsystem.cyfpol.menu;

/**
 * Interfejst definiujący zachowanie elementu, który może być "odwiedzany" za pomocą visitora impelementującego interfejs {@link IMenuVisitor}
 *
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 03.04.13 23:08
 */
public interface IVisitable
{
	public void accept(IMenuVisitor visitor);
}
