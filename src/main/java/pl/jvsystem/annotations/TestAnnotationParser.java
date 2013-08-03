package pl.jvsystem.annotations;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: DELL
 * Date: 01.02.13
 * Time: 22:06
 */
public class TestAnnotationParser
{
	public void parse(Class<?> clazz) throws Exception
	{
		Method[] methods = clazz.getMethods();

		for (Method method : methods)
		{
			if (method.isAnnotationPresent(Test.class))
			{
				Test test = method.getAnnotation(Test.class);
				String info = test.info();
				System.out.println("INFO:"+info);
//				method.invoke();
			}
		}
	}
}
