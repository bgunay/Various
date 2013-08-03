package pl.jvsystem.patterns.behavioral.chainofresponsibility;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 31.05.13 16:50
 */
public class Client
{
	public static void main(String[] args)
	{
		Logger chain = new StdOutLogger(Logger.DEBUG);
		Logger logger1 = new EmailLogger(Logger.NOTICE);
		chain.setNext(logger1);
		Logger logger2 = new StderrLogger(Logger.ERR);
		logger1.setNext(logger2);

		chain.message("Entering function y", Logger.DEBUG);
		chain.message("Step1 completed", Logger.NOTICE);
		chain.message("An error has occured", Logger.ERR);

	}
}
