package pl.jvsystem.guava;

import org.junit.Test;
import pl.jvsystem.Person;

import java.util.Arrays;
import java.util.stream.Stream;


/**
 * Date: 2014-05-02 21:26
 */
public class StreamTest {

	@Test
	public void streamingTest() {
		Stream<Integer> ints = Arrays.asList(1, 2, 3, 4, 5).stream();
		Stream<Integer> oddInts = ints.filter(n -> n%2 != 0);
		oddInts.forEach(System.out::println);
		Person p = new Person();
		p.setAge(12);
		p.setName("monika");
		System.out.println(p);
	}
}
