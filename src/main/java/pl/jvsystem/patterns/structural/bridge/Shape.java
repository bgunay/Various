package pl.jvsystem.patterns.structural.bridge;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 27.05.13 22:25
 */
public abstract class Shape
{
	protected DrawingAPI drawingAPI;

	protected Shape(DrawingAPI drawingAPI)
	{
		this.drawingAPI = drawingAPI;
	}

	public abstract void draw();

	public abstract void resizeByPercentage(double pct);

}
