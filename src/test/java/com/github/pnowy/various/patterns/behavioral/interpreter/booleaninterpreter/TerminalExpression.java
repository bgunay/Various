package com.github.pnowy.various.patterns.behavioral.interpreter.booleaninterpreter;

import java.util.StringTokenizer;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 01.06.13 18:56
 */
public class TerminalExpression extends Expression
{
	private String literal = null;

	public TerminalExpression(String literal)
	{
		this.literal = literal;
	}

	@Override
	public boolean interpret(String str)
	{
		StringTokenizer st = new StringTokenizer(str);
		while (st.hasMoreTokens())
		{
			String test = st.nextToken();
			if (test.equals(literal))
			{
				return true;
			}
		}
		return false;
	}
}
