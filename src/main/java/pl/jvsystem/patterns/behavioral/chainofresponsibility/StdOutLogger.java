package pl.jvsystem.patterns.behavioral.chainofresponsibility;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 31.05.13 16:46
 */
public class StdOutLogger extends Logger
{
	public StdOutLogger(int mask)
	{
		this.mask = mask;
	}

	@Override
	protected void writeMessage(String msg)
	{
		System.out.println("Writing to stdout: " + msg);
	}
}
