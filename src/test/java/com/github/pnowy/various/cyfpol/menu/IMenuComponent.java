package com.github.pnowy.various.cyfpol.menu;

/**
 * Interfejs dla elementów posiadających nazwę. Rozszerza równeiż interfejs {@link IVisitable}
 *
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 03.04.13 20:35
 */
public interface IMenuComponent extends IVisitable
{
	public String getName();
}
