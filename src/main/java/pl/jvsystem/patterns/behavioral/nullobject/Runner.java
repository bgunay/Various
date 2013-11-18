package pl.jvsystem.patterns.behavioral.nullobject;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 18.11.13 19:59
 */
public class Runner
{
	public static void main(String[] args)
	{
		ProductBase product = findById(0);
		product.rateIt(15);
		product = findById(15);
		product.rateIt(33);
	}

	public static ProductBase findById(int id)
	{
		if (id == 0)
		{
			return new Product();
		}

		return new NullProduct();
	}

}
