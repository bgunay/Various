package pl.jvsystem.cglib;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 07.09.13 21:30
 */
public class Algorithm
{
	public void runAlgorithm() {
		System.out.println("running the algorithm");
		try
		{
			// do something here
			Thread.sleep(500);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

	}
}
