package com.github.pnowy.various.patterns.behavioral.templateMethod.sortowanie;

import java.util.Arrays;

public class TestKaczek
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Kaczka[] kaczki = {
				new Kaczka("One", 4),
				new Kaczka("Two", 8),
				new Kaczka("Three", 12),
				new Kaczka("Four", 3),
				new Kaczka("Five", 22)
		};
		System.out.println("Przed sortowaniem:");
		display(kaczki);

		Arrays.sort(kaczki);

		System.out.println("Po sortowaniu:");
		display(kaczki);
	}

	private static void display(Kaczka[] kaczki)
	{
		for (Kaczka k : kaczki)
			System.out.println(k);
	}

}
