package com.github.pnowy.various.patterns.structural.bridge;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 27.05.13 22:34
 */
public class BridgePattern
{
	public static void main(String[] args)
	{
		Shape[] shapes = new Shape[] {
				new CircleShape(new DrawingAPI1(), 1,2,3), new CircleShape(new DrawingAPI2(), 5, 6, 7)
		};

		for(Shape s : shapes)
		{
			s.resizeByPercentage(2.5);
			s.draw();
		}
	}
}
