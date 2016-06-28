package com.github.pnowy.various.patterns.structural.proxy.protectionproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvocationHandlerNieWlasciciela implements InvocationHandler
{
	OsobaKomponent osoba;

	public InvocationHandlerNieWlasciciela(OsobaKomponent o)
	{
		this.osoba = o;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable
	{
		try
		{
			if (method.getName().startsWith("pobierz"))
			{
				return method.invoke(osoba, args);
			}
			else if (method.getName().equals("ustawRankingUrody"))
			{
				return method.invoke(osoba, args);
			}
			else if (method.getName().startsWith("ustaw"))
			{
				throw new IllegalAccessError();
			}
		}
		catch (InvocationTargetException e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
