package pl.jvsystem.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Date: 2014-05-03 14:08
 */
public class LambdaExpressionsTest {

	@Test
	public void testLambdaSorting() throws Exception {
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		Collections.sort(names, (a, b) -> b.compareTo(a));
		System.out.println(names);
	}

	@Test
	public void testLambdaConverter() throws Exception {
		Converter<String, Integer> converter = from -> Integer.valueOf(from);
		Integer converted = converter.convert("123");
		assertThat(converted).isEqualTo(123);
	}

	@Test
	public void testAccessingLocalVariables() throws Exception {
		final int num = 1;
		Converter<Integer, String> stringConverter = from -> String.valueOf(from + num);
		assertThat(stringConverter.convert(2)).isEqualTo("3");

		int num2 = 1;
		Converter<Integer, String> stringConverter2 = from -> String.valueOf(from + num2);
		assertThat(stringConverter2.convert(2)).isEqualTo("3");
	}

	static int outerStaticNum;
	int outerNum;

	@Test
	public void testAccessingFieldsAndStaticVariables() throws Exception {
		Converter<Integer, String> stringConverter1 = (from) -> {
			outerNum = 23;
			return String.valueOf(from);
		};

		Converter<Integer, String> stringConverter2 = (from) -> {
			outerStaticNum = 72;
			return String.valueOf(from);
		};
		stringConverter1.convert(12);
		stringConverter2.convert(12);
		assertThat(outerNum).isEqualTo(23);
		assertThat(outerStaticNum).isEqualTo(72);

	}
}
