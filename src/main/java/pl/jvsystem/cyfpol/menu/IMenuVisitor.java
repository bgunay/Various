package pl.jvsystem.cyfpol.menu;

/**
 * Interfejst definiujący zachowanie elementu, który może przeglądać strukturę menu.
 * Na potrzeby zarządznia odpowiednim "poziomem" został rozszerzony od dwie metody: {@link pl.cp.menu.IMenuVisitor#increaseIndent()}
 * oraz {@link pl.cp.menu.IMenuVisitor#decreaseIndent()} które służą do definiowania na którym poziomie struktury jesteśmy (zasadniczo takie zachowanie w
 * niektórych przypadkach może być określane w logice metod visit, czasami jednak trzeba określać je na poziomie przeglądania danego komponentu dlatego
 * zostały one wyciągnięte do interfejsu).
 *
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 03.04.13 23:04
 */
public interface IMenuVisitor
{
	void visit(MenuComponent menuComponent);
	void visit(CompositeMenuComponent compositeMenuComponent);
	void decreaseIndent();
	void increaseIndent();
}
