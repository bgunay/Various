package pl.jvsystem.guava;

import com.google.common.base.Stopwatch;

public class StopWatchTest
{

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Stopwatch s = new Stopwatch().start();
		for (int i = 0; i < 2500000; i++)
		{
			int a = 2;
			int b = 3;
			int sum = a + b;
		}

		s.stop();
	}

}