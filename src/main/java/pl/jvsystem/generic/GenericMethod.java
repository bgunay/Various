package pl.jvsystem.generic;

import java.util.List;

public class GenericMethod
{
	// gdybyśmy nie podali <T> w nawiasach kompilator pomyślałby że te to nazwa klasy i otrzymalibyśmy komunikat błedu że taki typ nie istnieje
	// dlatego musimy określić, że T to parametr typu a nie konkretny typ
	public <T extends Number> T process(List<T> numsList)
	{
		T max = numsList.get(0);

		for (T num : numsList)
			if (num.doubleValue() > max.doubleValue())
			{
				max = num;
			}

		return max;
	}

}
