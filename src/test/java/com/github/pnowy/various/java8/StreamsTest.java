package com.github.pnowy.various.java8;

import com.google.common.base.Stopwatch;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamsTest {
	private static final Logger LOG = LoggerFactory.getLogger(StreamsTest.class);
	private List<String> stringCollection = new ArrayList<>();
	private List<Integer> integerCollection = new ArrayList<>();

	@Before
	public void setUp() throws Exception {
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");

		integerCollection.add(1);
		integerCollection.add(2);
		integerCollection.add(3);
		integerCollection.add(4);
		integerCollection.add(5);
	}


	@Test
	public void collectTest() {
		System.out.println(integerCollection.stream().map(Object::toString).iterator());
		//integerCollection.stream().map(Object::toString).collect(Collectors.toList()).forEach(i -> System.out.println(i.getClass()));
	}

	@Test
	public void streamingTest() {
		Stream<Integer> ints = Arrays.asList(1, 2, 3, 4, 5).stream();
		Stream<Integer> oddInts = ints.filter(n -> n % 2 != 0);
		oddInts.forEach(System.out::println);
	}

	@Test
	public void testFilterStream() throws Exception {
		stringCollection.stream().filter(o -> o.startsWith("a")).forEach(System.out::println);
	}

	@Test
	public void testSortedStream() throws Exception {
		stringCollection.stream().sorted().filter(o -> o.startsWith("a")).forEach(System.out::println);
	}

	@Test
	public void testMap() throws Exception {
		stringCollection.stream().map(String::toUpperCase).forEach(System.out::println);
	}

	@Test
	public void testMatch() throws Exception {
		boolean anyStartsWithA =
				stringCollection
						.stream()
						.anyMatch((s) -> s.startsWith("a"));
		assertThat(anyStartsWithA).isTrue();

		boolean allStartsWithA =
				stringCollection
						.stream()
						.allMatch((s) -> s.startsWith("a"));
		assertThat(allStartsWithA).isFalse();
	}

	@Test
	public void testCount() throws Exception {
		long startsWithB =
				stringCollection
						.stream()
						.filter((s) -> s.startsWith("b"))
						.count();
		assertThat(startsWithB).isEqualTo(3);
	}

	@Test
	public void testReduce() throws Exception {
		Optional<String> reduced = stringCollection.stream().sorted().reduce((s1, s2) -> s1 + "#" + s2);
		reduced.ifPresent(System.out::println);
	}

	@Test
	public void testSequentialAndParralerSort() throws Exception {
		List<String> values = getUniqueList();
		Stopwatch s = Stopwatch.createStarted();
		values.stream().sorted().count();
		LOG.info("T1: {} ms", s.elapsed(TimeUnit.MILLISECONDS));

		s = Stopwatch.createStarted();
		values.parallelStream().sorted().count();
		LOG.info("T2: {} ms", s.elapsed(TimeUnit.MILLISECONDS));
	}

	public List<String> getUniqueList() {
		int max = 1000000;
		List<String> values = new ArrayList<>(max);
		for (int i = 0; i < max; i++) {
			UUID uuid = UUID.randomUUID();
			values.add(uuid.toString());
		}
		return values;
	}

}
