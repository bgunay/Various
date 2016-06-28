package com.github.pnowy.various.patterns.structural.bridge;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 27.05.13 22:22
 */
public class DrawingAPI1 implements DrawingAPI
{
	@Override
	public void drawCircle(double x, double y, double radius)
	{
		System.out.printf("API1.circle at %f:%f radius %f\n", x, y, radius);
	}
}
