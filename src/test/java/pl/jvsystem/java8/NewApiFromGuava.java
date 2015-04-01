package pl.jvsystem.java8;

import org.junit.Test;
import pl.jvsystem.domain.Person;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;


public class NewApiFromGuava {
	@Test
	public void testPredicates() throws Exception {
		Predicate<String> predicate = s -> s.length() > 0;
		assertThat(predicate.test("foo")).isTrue();
		assertThat(predicate.test("")).isFalse();
		assertThat(predicate.negate().test("foo")).isFalse();

		Predicate<Boolean> nonNull = Objects::nonNull;
		Predicate<Boolean> isNull = Objects::isNull;
		assertThat(isNull.test(null)).isTrue();

		Predicate<String> isEmpty = String::isEmpty;
		Predicate<String> isNotEmpty = isEmpty.negate();
	}

	@Test
	public void testFunction() throws Exception {
		Function<String, Integer> toInteger = Integer::valueOf;
		// the types on the left side describes the types at start and at end of processig (STRING -> INTEGER -> STRING)
		Function<String, String> backToString = toInteger.andThen(String::valueOf);
		backToString.apply("123");
	}

	@Test
	public void testSupplier() throws Exception {
		Supplier<Car> carSupplier = Car::new;
		carSupplier.get();   // new Car
	}

	@Test
	public void testConsumers() throws Exception {
		Consumer<Car> greeter = (c) -> System.out.println("Super car: " + c.model);
		greeter.accept(new Car("Octavia", "Skoda"));
	}

	@Test
	public void testComparators() throws Exception {
		Comparator<Person> comparator = (p1, p2) -> p1.getFirstName().compareTo(p2.getLastName());

		Person p1 = new Person("John", "Doe");
		Person p2 = new Person("Alice", "Wonderland");

		comparator.compare(p1, p2);             // > 0
		comparator.reversed().compare(p1, p2);  // < 0
	}

	@Test
	public void testOptional() throws Exception {
		Optional<String> optional = Optional.of("bam");

		assertThat(optional.isPresent()).isTrue();
		assertThat(optional.get()).isEqualTo("bam");
		assertThat(optional.orElse("fallback")).isEqualTo("bam");

		optional.ifPresent((s) -> System.out.println(s.charAt(0)));
	}
}
