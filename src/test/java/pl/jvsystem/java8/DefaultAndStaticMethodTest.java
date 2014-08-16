package pl.jvsystem.java8;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.junit.Test;

/**
 * Date: 2014-05-03 14:01
 */
public class DefaultAndStaticMethodTest {

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

	@Test
	public void testStaticMethod() throws Exception {
		double x = Formula.max(10, 12);
		assertThat(x).isEqualTo(12);
	}

	@Test
	public void testControlFlow() throws Exception {
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		assertThat(names.stream().anyMatch(Objects::isNull)).isFalse();
	}
}
