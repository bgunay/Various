package com.github.pnowy.various.patterns.behavioral.interpreter.romaninterpreter;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 01.06.13 18:29
 */
public class Context
{
	private String input;
	private int output;

	public Context(String input)
	{
		this.input = input;
	}

	public String getInput()
	{
		return input;
	}

	public void setInput(String input)
	{
		this.input = input;
	}

	public int getOutput()
	{
		return output;
	}

	public void setOutput(int output)
	{
		this.output = output;
	}
}
