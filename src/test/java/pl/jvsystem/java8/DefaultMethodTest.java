package pl.jvsystem.java8;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Date: 2014-05-03 14:01
 */
public class DefaultMethodTest {

	@Test
	public void defaultMethodTest() {
		Formula f = new MagicFormula();
		double calculateResult = f.calculate(100);
		double sqrtResult = f.sqrt(16);
		assertThat(calculateResult).isEqualTo(100);
		assertThat(sqrtResult).isEqualTo(4);
	}

	@Test
	public void testAccessingDefaultMethod() throws Exception {
		Formula f = new MagicFormula();
		assertThat(f.sqrt(16)).isEqualTo(4);
	}
}
