package pl.jvsystem.patterns.behavioral.interpreter.booleaninterpreter;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 01.06.13 19:03
 */
public class OrExpression extends Expression {

	private Expression expression1;
	private Expression expression2;

	public OrExpression(Expression expression1, Expression expression2)
	{
		this.expression1 = expression1;
		this.expression2 = expression2;
	}

	@Override
	public boolean interpret(String str)
	{
		return expression1.interpret(str) || expression2.interpret(str);
	}
}
