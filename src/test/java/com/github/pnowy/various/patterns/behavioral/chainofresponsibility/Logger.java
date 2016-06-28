package com.github.pnowy.various.patterns.behavioral.chainofresponsibility;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 31.05.13 16:42
 */
public abstract class Logger
{
	public static final int ERR = 3;
	public static final int NOTICE = 5;
	public static final int DEBUG = 7;

	protected int mask;
	protected Logger next;

	public void setNext(Logger log)
	{
		next = log;
	}

	public void message(String msg, int priority)
	{
		if (priority <= mask)
			writeMessage(msg);

		if (next != null)
			next.message(msg, priority);
	}

	abstract protected void writeMessage(String msg);

}
