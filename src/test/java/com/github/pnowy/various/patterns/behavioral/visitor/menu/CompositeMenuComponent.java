package com.github.pnowy.various.patterns.behavioral.visitor.menu;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Nieco bardziej rozbudowany od {@link MenuComponent} element menu. Może przechowywać zbiór elementów podrzędnych.
 *
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 03.04.13 20:38
 */
public class CompositeMenuComponent implements IMenuComponent, IVisitable
{
	private String name;
	private List<IMenuComponent> elements = Lists.newArrayList();

	public CompositeMenuComponent()
	{
	}

	public CompositeMenuComponent(String name)
	{
		Preconditions.checkNotNull(name, "Name cannot be null...");
		this.name = name;
	}

	@Override
	public String getName()
	{
		return name;
	}

	public void add(IMenuComponent menuComponent)
	{
		Preconditions.checkNotNull(menuComponent, "Menu component cannot be null...");
		this.elements.add(menuComponent);
	}

	public List<IMenuComponent> getChildren()
	{
		return elements;
	}

	@Override
	public void accept(IMenuVisitor visitor)
	{
		visitor.visit(this);
		for(IMenuComponent mc : getChildren())
		{
			mc.accept(visitor);
		}
		visitor.decreaseIndent();
	}
}
