package com.github.pnowy.various.patterns.behavioral.iterator.kompozyt;

import java.util.Iterator;

public class IteratorPusty implements Iterator {

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public Object next() {
		return null;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
