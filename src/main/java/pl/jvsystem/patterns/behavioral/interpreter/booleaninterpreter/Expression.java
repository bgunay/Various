package pl.jvsystem.patterns.behavioral.interpreter.booleaninterpreter;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 01.06.13 18:45
 */
public abstract class Expression
{
	abstract public boolean interpret(String str);
}
