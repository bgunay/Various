package pl.jvsystem.concurrency;

import java.util.concurrent.Callable;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 27.08.13 22:14
 */
public class CallableString implements Callable<String>
{
	@Override
	public String call() throws Exception
	{
		Thread.sleep(1000);
		return Thread.currentThread().getName();
	}
}
