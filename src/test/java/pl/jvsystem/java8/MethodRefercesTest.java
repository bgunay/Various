package pl.jvsystem.java8;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;


/**
 * Date: 2014-05-03 14:44
 */
public class MethodRefercesTest {
	@Test
	public void testMethodReference() throws Exception {
		Converter<String, Integer> converter = Integer::valueOf;
		Integer converted = converter.convert("123");
		assertThat(converted).isEqualTo(123);

		Something something = new Something();
		Converter<String, String> stringConverter = something::startsWith;
		String firstLetterOfJava = stringConverter.convert("Java");
		assertThat(firstLetterOfJava).isEqualTo("J");
	}

	@Test
	public void testConstructorReference() throws Exception {
		CarFactory<Car> carFactory = Car::new;
		Car c = carFactory.create("Octavia", "Skoda");
		assertThat(c.brand).isEqualTo("Skoda");
	}
}
