package pl.jvsystem.patterns.structural.bridge;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 27.05.13 22:24
 */
public class DrawingAPI2 implements DrawingAPI
{
	@Override
	public void drawCircle(double x, double y, double radius)
	{
		System.out.printf("API2.circle at %f:%f radius %f\n", x, y, radius);
	}
}
