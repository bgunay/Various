package com.github.pnowy.various.patterns.creational.singleton;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com> Date: 01.07.13 09:35
 */
public class SingletonTest {

	public static void main(String[] args) {
		System.out.println(Singleton.instance().getMap());

		System.out.println(Singleton.instance().getMap());
	}
}
