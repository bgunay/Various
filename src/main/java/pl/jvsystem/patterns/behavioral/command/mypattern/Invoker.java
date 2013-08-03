package pl.jvsystem.patterns.behavioral.command.mypattern;

/**
 * The invoker class.
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 21.04.13 14:43
 */
public class Invoker
{
	private Command command;

	public void setCommand(Command command)
	{
		this.command = command;
		System.out.println("Set command: " + command);
	}

	public void executeCommand()
	{
		System.out.println("Execute command: " + command);
		command.execute();
	}

}
