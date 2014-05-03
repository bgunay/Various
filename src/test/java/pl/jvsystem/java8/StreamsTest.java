package pl.jvsystem.java8;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.Test;


/**
 * Date: 2014-05-02 21:26
 */
public class StreamsTest {

	@Test
	public void streamingTest() {
		Stream<Integer> ints = Arrays.asList(1, 2, 3, 4, 5).stream();
		Stream<Integer> oddInts = ints.filter(n -> n%2 != 0);
		oddInts.forEach(System.out::println);
	}
}
