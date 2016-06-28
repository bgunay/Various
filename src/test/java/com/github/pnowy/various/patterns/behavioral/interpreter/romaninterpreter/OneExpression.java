package com.github.pnowy.various.patterns.behavioral.interpreter.romaninterpreter;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 01.06.13 18:33
 */
public class OneExpression extends Expression
{
	public String one()
	{
		return "I";
	}

	public String four()
	{
		return "IV";
	}

	public String five()
	{
		return "V";
	}

	public String nine()
	{
		return "IX";
	}

	public int multiplier()
	{
		return 1;
	}
}
