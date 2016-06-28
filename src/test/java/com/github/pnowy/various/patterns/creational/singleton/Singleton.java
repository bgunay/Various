package com.github.pnowy.various.patterns.creational.singleton;

import java.util.HashMap;
import java.util.Map;

public class Singleton
{
	private static Singleton instance = new Singleton();

	private Map<String, String > map;

	private Singleton()
	{
	}

	public Map<String, String > getMap()
	{
		if (map == null)
		{
			map = new HashMap<String, String>();
			map.put("ala","kot");
		}
		return map;
	}

	public static Singleton instance()
	{
		// double check - working since Java 1.5
		if (instance == null)
		{
			synchronized (Singleton.class)
			{
				if (instance == null)
				{
					instance = new Singleton();
				}
			}
		}

		return instance;
	}

	// other methods
}
