package pl.jvsystem.patterns.behavioral.interpreter.romaninterpreter;

import java.util.ArrayList;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 01.06.13 18:40
 */
public class Client
{
	public static void main(String[] args)
	{
		String roman = "III";
		Context context = new Context(roman);

		// Build the 'parse tree'
		ArrayList<Expression> tree = new ArrayList<Expression>();
		tree.add(new ThousandExpression());
		tree.add(new HundredExpression());
		tree.add(new TenExpression());
		tree.add(new OneExpression());

		// Interpret
		for (Expression exp : tree)
		{
			exp.interpret(context);
		}

		System.out.println(roman + " = " + Integer.toString(context.getOutput()));
	}
}
