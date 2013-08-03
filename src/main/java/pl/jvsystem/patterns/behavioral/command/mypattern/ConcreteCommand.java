package pl.jvsystem.patterns.behavioral.command.mypattern;

/**
 * Concrete command.
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 21.04.13 14:32
 *
 * Konkretne polecenie, np. włącz światło.
 */
public class ConcreteCommand implements Command
{
	private Receiver receiver;

	public ConcreteCommand(Receiver receiver)
	{
		this.receiver = receiver;
	}

	@Override
	public void execute()
	{
		receiver.action();
	}

	@Override
	public String toString()
	{
		return "ConcreteCommand";
	}
}
