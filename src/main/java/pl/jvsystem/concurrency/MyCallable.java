package pl.jvsystem.concurrency;

import java.util.concurrent.Callable;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 06.05.13 22:38
 */
public class MyCallable implements Callable<Long>
{
	@Override
	public Long call() throws Exception
	{
		long sum = 0;
		for (int i = 0; i < 100; i++)
		{
			sum += i;
		}
		return sum;
	}
}
