package com.github.pnowy.various.patterns.behavioral.chainofresponsibility;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 31.05.13 16:48
 */
public class EmailLogger extends Logger
{
	public EmailLogger(int mask)
	{
		this.mask = mask;
	}

	@Override
	protected void writeMessage(String msg)
	{
		System.out.println("Sending via email: " + msg);
	}
}
