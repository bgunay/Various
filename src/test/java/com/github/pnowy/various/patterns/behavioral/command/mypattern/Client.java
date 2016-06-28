package com.github.pnowy.various.patterns.behavioral.command.mypattern;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 21.04.13 14:46
 */
public class Client
{
	public static void main(String[] args)
	{
		Invoker invoker = new Invoker();
		Receiver receiver = new Receiver();
		Command command = new ConcreteCommand(receiver);

		invoker.setCommand(command);
		invoker.executeCommand();
	}
}
