package com.github.pnowy.various.patterns.behavioral.interpreter.romaninterpreter;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 01.06.13 18:34
 */
public class ThousandExpression extends Expression
{
	public String one()
	{
		return "M";
	}

	public String four()
	{
		return " ";
	}

	public String five()
	{
		return " ";
	}

	public String nine()
	{
		return " ";
	}

	public int multiplier()
	{
		return 1000;
	}
}
