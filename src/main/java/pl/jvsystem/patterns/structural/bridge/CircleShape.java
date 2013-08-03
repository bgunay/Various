package pl.jvsystem.patterns.structural.bridge;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 27.05.13 22:26
 */
public class CircleShape extends Shape
{
	private double x,y,radius;

	public CircleShape(DrawingAPI drawingAPI, double radius, double x, double y)
	{
		super(drawingAPI);
		this.radius = radius;
		this.x = x;
		this.y = y;
	}

	@Override
	public void draw()
	{
		drawingAPI.drawCircle(x, y, radius);
	}

	@Override
	public void resizeByPercentage(double pct)
	{
		radius *= pct;
	}
}
