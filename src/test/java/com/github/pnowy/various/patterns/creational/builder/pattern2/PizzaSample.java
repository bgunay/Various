package com.github.pnowy.various.patterns.creational.builder.pattern2;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 05.05.13 19:59
 */
public class PizzaSample {
	public static void main(String[] args)
	{
		Pizza pizza = new Pizza.Builder(12).cheese(true).pepperoni(true).build();
		System.out.println("PIZZA:"+pizza);
	}
}
