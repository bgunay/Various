package com.github.pnowy.various.patterns.structural.adapter.mypattern;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 29.04.13 21:47
 */
public class ExtendImmutableContractor
{

	public String getDesc()
	{
		System.out.println("getDesc in extend immutable contractor");
		return this.getClass().getName();
	}

}
