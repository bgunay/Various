package pl.jvsystem.guava;

import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;

public class PaddingTest
{

	public static void main(String[] args)
	{
		Double value = 3.14;
		String printValue = Strings.padStart(String.valueOf(value), 8, '0');
		System.out.println("PRINTED VALUE: " + printValue);

		String alfa = null;

		String beta = StringUtils.trimToEmpty(alfa) + " | test";
		String teta = StringUtils.trimToEmpty(beta) + " | test";
		System.out.println(teta);
	}

}
