package pl.jvsystem.concurrency.rxjava;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

import java.util.Arrays;
import java.util.List;

/**
 * RxBaseTest
 */
public class RxBaseTest {
	private static final Logger LOG = LoggerFactory.getLogger(RxBaseTest.class);

    // added new line

	@Test
	public void helloWorldTest() {
		Observable<String> myObservable = Observable.create(new Observable.OnSubscribe<String>() {
			@Override
			public void call(Subscriber<? super String> subscriber) {
				subscriber.onNext("Hello world!");
				subscriber.onCompleted();
			}
		});

		Subscriber<String> mySubscriber = new Subscriber<String>() {
			@Override
			public void onCompleted() {

			}

			@Override
			public void onError(Throwable e) {

			}

			@Override
			public void onNext(String s) {
				LOG.info(s);
			}
		};

		myObservable.subscribe(mySubscriber);

	}

	@Test
	public void helloWorldSimplified() {
		Observable<String> myObservable = Observable.just("Hello");
		Action1<String> onNextAction = new Action1<String>() {
			@Override
			public void call(String s) {
				LOG.info(s);
			}
		};
		myObservable.subscribe(onNextAction);
	}

	@Test
	public void helloWorldSimplified2() {
		Observable.just("Hello").subscribe(LOG::info);
	}

	@Test
	public void testMapOperator() {
//		Observable.just("Hello").map(String::toUpperCase).subscribe(LOG::info);
//		Observable.just("Hello").map(String::hashCode).subscribe(hashCode -> LOG.info("Value of hashCode: {}", hashCode));
//		Observable.from()
//				.flatMap(Observable::from)
//				.subscribe(n -> LOG.info(n))
//		;

		query()
			.flatMap(Observable::from)
			.subscribe(urls -> LOG.info("query element: {}", urls));

	}

	private Observable<List<String>> query() {
		return Observable.from(Arrays.asList("one", "two", "three"), Arrays.asList("four", "five", "six"));
	}


}
