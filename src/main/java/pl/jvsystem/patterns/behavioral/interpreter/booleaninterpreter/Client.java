package pl.jvsystem.patterns.behavioral.interpreter.booleaninterpreter;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 01.06.13 19:07
 */
public class Client
{
	public static void main(String[] args)
	{
		String context = "Owen John";

		Expression define = buildInterpreterTree();

		System.out.println(context + " is " + define.interpret(context));
	}

	static Expression buildInterpreterTree()
	{
		// Literal
		Expression terminal1 = new TerminalExpression("John");
		Expression terminal2 = new TerminalExpression("Henry");
		Expression terminal3 = new TerminalExpression("Mary");
		Expression terminal4 = new TerminalExpression("Owen");

		// Henry or Mary
		Expression alternation1 = new OrExpression(terminal2, terminal3);

		// John or (Henry or Mary)
		Expression alternation2 = new OrExpression(terminal1, alternation1);

		// Owen and (John or (Henry or Mary))
		return new AndExpression(terminal4, alternation2);
	}

}
