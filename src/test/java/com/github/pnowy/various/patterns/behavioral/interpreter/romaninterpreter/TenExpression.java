package com.github.pnowy.various.patterns.behavioral.interpreter.romaninterpreter;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 01.06.13 18:33
 */
public class TenExpression extends Expression
{
	public String one()
	{
		return "X";
	}

	public String four()
	{
		return "XL";
	}

	public String five()
	{
		return "L";
	}

	public String nine()
	{
		return "XC";
	}

	public int multiplier()
	{
		return 10;
	}
}
