package pl.jvsystem.concurrency.rxjava;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rx.Observable;
import rx.Subscriber;

/**
 * RxJavaTest
 */
public class RxJavaTest {
	private static final Logger LOG = LoggerFactory.getLogger(RxJavaTest.class);
	@Test
	public void test() {
		Observable<Integer> obs = Observable.from(1, 2, 3, 4, 5);
		obs.map(i -> i * 10)
				.filter(i -> i > 20)
				.flatMap(i -> Observable.from(i, -i))
				.map(Object::toString)
				.subscribe(LOG::info);

	}

	@Test
	public void testBlockingObservable() {
		Observable<Integer> obs = Observable.from(1, 2, 3, 4, 5);
		obs.map(i -> i * 10)
				.filter(i -> i > 20)
				.flatMap(i -> Observable.from(i, -i))
				.map(Object::toString)
				.toBlocking().forEach(LOG::info);

		Observable<Integer> o = Observable.create((Subscriber<? super Integer> subscriber) -> subscriber.onNext(3));
	}

	@Test
	public void testBaseExample() {
		Observable.from("one", "two", "three")
				.take(2)
				.subscribe(System.out::println);
	}

	@Test
	public void testRandomObservable() {
		RandomObservable integers = new RandomObservable();
		integers.take(5).subscribe(System.out::println);
	}

}
