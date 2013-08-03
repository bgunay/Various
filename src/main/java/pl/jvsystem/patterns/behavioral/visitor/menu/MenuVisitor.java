package pl.jvsystem.patterns.behavioral.visitor.menu;

import com.google.common.base.Strings;

/**
 * Komponent definiujący charakterystyczne przeglądanie menu z wcięciami oraz znakiem '-' dla liści oraz '+' dla elementów posiadających potomków.
 *
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 03.04.13 23:41
 */
public class MenuVisitor implements IMenuVisitor
{
	private static int DEFAULT_INDENT = 5;
	private int level = 0;

	@Override
	public void visit(MenuComponent menuComponent)
	{
		String label = Strings.repeat(" ", level * DEFAULT_INDENT) + "- " + menuComponent.getName();
		System.out.println(label);
	}

	@Override
	public void visit(CompositeMenuComponent compositeMenuComponent)
	{
		String label = Strings.repeat(" ", level * DEFAULT_INDENT) + "+ " + compositeMenuComponent.getName();
		System.out.println(label);
		increaseIndent();
	}

	@Override
	public void decreaseIndent()
	{
		level--;
	}

	@Override
	public void increaseIndent()
	{
		level++;
	}
}
