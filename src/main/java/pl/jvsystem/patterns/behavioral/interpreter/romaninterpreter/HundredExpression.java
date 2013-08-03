package pl.jvsystem.patterns.behavioral.interpreter.romaninterpreter;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 01.06.13 18:34
 */
public class HundredExpression extends Expression
{
	public String one()
	{
		return "C";
	}

	public String four()
	{
		return "CD";
	}

	public String five()
	{
		return "D";
	}

	public String nine()
	{
		return "CM";
	}

	public int multiplier()
	{
		return 100;
	}
}
