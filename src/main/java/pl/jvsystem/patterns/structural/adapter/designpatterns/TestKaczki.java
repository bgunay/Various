package pl.jvsystem.patterns.structural.adapter.designpatterns;

public class TestKaczki
{

	public static void main(String[] args)
	{
		Indyk i = new DzikiIndyk();
		Kaczka indykAdapter = new IndykAdapter(i);
		testujKaczke(indykAdapter);
	}

	static void testujKaczke(Kaczka k)
	{
		k.kwacz();
		k.lataj();
	}

}