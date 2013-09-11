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

	public void invokeThis(Object theObject)
	{
		try
		{
			Method[] methods = Class.forName(theObject.getClass().getName()).getMethods();
			for (Method method : methods)
			{
				InvokeMultiple invokeMultiple = method.getAnnotation(InvokeMultiple.class);
				if (invokeMultiple != null)
				{
					int numberOfTimesToInvoke = invokeMultiple.numberOfTimesToInvoke();
					for (int j = 0; j < numberOfTimesToInvoke; j++)
					{
						method.invoke(theObject, null);
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
