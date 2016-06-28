package com.github.pnowy.various.patterns.creational.prototype;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 23.05.13 20:26
 */
public class Client {
	public static void main(String[] args)
	{
		ItemRegistry ir = new ItemRegistry();
		Item myBook = ir.createBasicItem("book");
		myBook.setTitle("Custom Title");

	}
}
