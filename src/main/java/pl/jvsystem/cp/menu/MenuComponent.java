package pl.jvsystem.cp.menu;

import com.google.common.base.Preconditions;

/**
 * Najprostszy komponent menu, tzw. liść, nie może zawierać on potomów, jest najniższym elementem w strukturze.
 *
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 03.04.13 21:10
 */
public class MenuComponent implements IMenuComponent
{
	private String name;

	public MenuComponent(String name)
	{
		Preconditions.checkNotNull(name, "Name cannot be null...");
		this.name = name;
	}

	@Override
	public String getName()
	{
		return this.name;
	}

	@Override
	public void accept(IMenuVisitor visitor)
	{
		visitor.visit(this);
	}
}
