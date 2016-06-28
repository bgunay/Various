package com.github.pnowy.various.annotations;

/**
 * Created with IntelliJ IDEA.
 * User: DELL
 * Date: 01.02.13
 * Time: 22:23
 */
public class Demo
{
	public static void main(String[] args) throws Exception
	{
		TestAnnotationParser parser = new TestAnnotationParser();
		parser.parse(Annotated.class);
		TestObject testObject = new TestObject("Przemek", "Nowak");
		parser.invokeThis(testObject);
	}
}
