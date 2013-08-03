package pl.jvsystem.patterns.behavioral.chainofresponsibility;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 31.05.13 16:49
 */
public class StderrLogger extends Logger
{
	public StderrLogger(int mask)
	{
		this.mask = mask;
	}

	@Override
	protected void writeMessage(String msg)
	{
		System.err.println("Sendint to stderr: " + msg);
	}
}
