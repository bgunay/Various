package com.github.pnowy.various.patterns.structural.adapter.enumeration;

import java.util.Enumeration;
import java.util.Iterator;

public class EnumerationIterator implements Iterator
{
	Enumeration enumeration;

	public EnumerationIterator(Enumeration e)
	{
		this.enumeration = e;
		this.getClass();
	}

	public boolean hasNext()
	{
		return enumeration.hasMoreElements();
	}

	public Object next()
	{
		return enumeration.nextElement();
	}

	public void remove()
	{
		throw new UnsupportedOperationException();
	}

}
