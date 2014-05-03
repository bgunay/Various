package pl.jvsystem.javaAndGroovy;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import pl.jvsystem.domain.Person;

/**
 * Date: 2014-05-03 13:30
 */
public class PersonTest {

	@Test
	public void personTest() {
		Person p = new Person("Monika", 15);
		assertThat(p.getName()).isEqualTo("Monika");
		assertThat(p.getAge()).isEqualTo(15);
	}

}
