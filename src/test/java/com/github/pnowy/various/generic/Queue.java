package com.github.pnowy.various.generic;

/**
 * Prosty interfejs kolejki.
 *
 * @author przemek nowak <przemek.nowak.pl@gmail.com>
 */
public interface Queue<E>
{
	void add(E element);

	E remove();

	int size();
}
